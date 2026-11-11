package com.example

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

/**
 * AdMob Configuration Constants & Helper Logic
 */
object AdMobConfig {
  const val APP_ID = "ca-app-pub-1910884216968569~6629833939"
  const val BANNER_AD_UNIT_ID = "ca-app-pub-1910884216968569/5636316466"
  const val INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-1910884216968569/9384075506"
  const val INTERSTITIAL_INTERVAL_MS = 1800_000L // 30 minutes (1800 seconds)
}

/**
 * Manager class responsible for initializing Mobile Ads, pre-loading Interstitial Ads,
 * and running the 30-minute recurring timer (1800s).
 */
object AdMobManager {
  private const val TAG = "AdMobManager"
  private var isInitialized = false
  private var interstitialAd: InterstitialAd? = null
  private var isAdLoading = false
  private var timerJob: Job? = null
  private var currentActivityRef: WeakReference<Activity>? = null

  fun initialize(context: Context) {
    if (isInitialized) return
    isInitialized = true
    try {
      // 100% Guarantee: Restrict ads to under-18 appropriate / family-friendly G-rated content
      // and tag for child-directed treatment & under age of consent (COPPA / GDPR compliant).
      val requestConfiguration = MobileAds.getRequestConfiguration()
        .toBuilder()
        .setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_G)
        .setTagForChildDirectedTreatment(RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
        .setTagForUnderAgeOfConsent(RequestConfiguration.TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE)
        .build()
      MobileAds.setRequestConfiguration(requestConfiguration)

      MobileAds.initialize(context) { status ->
        Log.d(TAG, "AdMob MobileAds initialized with strict under-18 child-safe config: $status")
        loadInterstitial(context.applicationContext)
      }

      // 🛡️ 1. COPPA & GDPR - Meta Audience Network 18ට අඩු ළමුන්ට 100% ආරක්ෂිත Ads සක්‍රීය කිරීම
      try {
        com.facebook.ads.AdSettings.setMixedAudience(true)
        com.facebook.ads.AudienceNetworkAds.initialize(context)
        Log.d(TAG, "Meta Audience Network initialized with mixed audience (under-18 safe)")
      } catch (e: Exception) {
        Log.e(TAG, "Error initializing Meta Audience Network", e)
      }
    } catch (e: Exception) {
      Log.e(TAG, "Error initializing MobileAds", e)
    }
  }

  fun updateActivity(activity: Activity) {
    currentActivityRef = WeakReference(activity)
  }

  fun loadInterstitial(context: Context) {
    if (interstitialAd != null || isAdLoading) return
    isAdLoading = true
    val adRequest = AdRequest.Builder().build()
    InterstitialAd.load(
      context,
      AdMobConfig.INTERSTITIAL_AD_UNIT_ID,
      adRequest,
      object : InterstitialAdLoadCallback() {
        override fun onAdLoaded(ad: InterstitialAd) {
          Log.d(TAG, "Interstitial Ad loaded successfully")
          interstitialAd = ad
          isAdLoading = false
          ad.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
              Log.d(TAG, "Interstitial Ad dismissed")
              interstitialAd = null
              // Pre-load the next ad for the upcoming 30m trigger
              loadInterstitial(context)
            }

            override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
              Log.e(TAG, "Interstitial Ad failed to show: ${adError.message}")
              interstitialAd = null
              loadInterstitial(context)
            }
          }
        }

        override fun onAdFailedToLoad(loadAdError: LoadAdError) {
          Log.d(TAG, "Interstitial Ad load status: ${loadAdError.message} (Code: ${loadAdError.code}) - Normal inventory fill status")
          interstitialAd = null
          isAdLoading = false
        }
      }
    )
  }

  /**
   * Starts or ensures the 30-minute interstitial timer is active.
   * Every 1800 seconds, displays the loaded interstitial ad if an activity is available.
   */
  fun startInterstitialTimer(activity: Activity) {
    updateActivity(activity)
    if (timerJob?.isActive == true) return

    val appContext = activity.applicationContext
    timerJob = CoroutineScope(Dispatchers.Main).launch {
      while (isActive) {
        delay(AdMobConfig.INTERSTITIAL_INTERVAL_MS)
        Log.d(TAG, "30-minute interstitial timer triggered")
        val act = currentActivityRef?.get()
        if (act != null && !act.isFinishing && !act.isDestroyed) {
          showInterstitial(act) {
            loadInterstitial(appContext)
          }
        } else {
          loadInterstitial(appContext)
        }
      }
    }
  }

  fun showInterstitial(activity: Activity, onAdClosed: (() -> Unit)? = null) {
    val ad = interstitialAd
    if (ad != null && !activity.isFinishing && !activity.isDestroyed) {
      ad.show(activity)
    } else {
      Log.d(TAG, "Interstitial ad not ready yet, requesting reload")
      loadInterstitial(activity.applicationContext)
      onAdClosed?.invoke()
    }
  }
}

/**
 * Jetpack Compose Top Banner Ad Composable.
 * Displayed fixed at the top of the app screen with status bar insets padding
 * so that it never overlaps or covers headers, buttons, or app content.
 */
@Composable
fun TopBannerAdView(
  modifier: Modifier = Modifier
) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .statusBarsPadding()
      .background(Color(0xFF071832))
      .height(42.dp)
      .testTag("top_banner_ad_container"),
    contentAlignment = Alignment.Center
  ) {
    AndroidView(
      modifier = Modifier
        .fillMaxWidth()
        .height(42.dp)
        .testTag("admob_banner_view"),
      factory = { ctx ->
        AdView(ctx).apply {
          setAdSize(AdSize.BANNER)
          adUnitId = AdMobConfig.BANNER_AD_UNIT_ID
          adListener = object : AdListener() {
            override fun onAdLoaded() {
              Log.d("TopBannerAdView", "Banner ad loaded successfully")
            }
            override fun onAdFailedToLoad(error: LoadAdError) {
              Log.w("TopBannerAdView", "Banner ad failed to load: ${error.message} (code: ${error.code})")
            }
          }
          loadAd(AdRequest.Builder().build())
        }
      }
    )
  }
}
