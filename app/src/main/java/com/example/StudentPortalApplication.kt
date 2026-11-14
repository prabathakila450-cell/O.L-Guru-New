package com.example

import android.app.Application
import android.os.Build
import android.webkit.WebView
import java.io.File

class StudentPortalApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    // Multi-process safety for WebView in Android 9+ (API 28+)
    var activeProcessName: String? = null
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
      try {
        activeProcessName = getProcessName()
        if (packageName != activeProcessName) {
          WebView.setDataDirectorySuffix(activeProcessName)
        }
      } catch (_: Exception) {}
    }

    // Pre-create Chromium WebView cache directories on a background thread
    // so Application.onCreate() never blocks the Main Thread.
    val appCacheDir = cacheDir
    Thread {
      initWebViewCacheDirectories(appCacheDir)
    }.start()
  }

  companion object {
    fun initWebViewCacheDirectories(baseCacheDir: File) {
      try {
        val webViewDir = File(baseCacheDir, "WebView")
        val defaultDir = File(webViewDir, "Default")
        val httpCacheDir = File(defaultDir, "HTTP Cache")
        val codeCacheDir = File(httpCacheDir, "Code Cache")
        val wasmDir = File(codeCacheDir, "wasm")
        val jsDir = File(codeCacheDir, "js")

        val targetDirs = listOf(
          baseCacheDir,
          webViewDir,
          defaultDir,
          httpCacheDir,
          codeCacheDir,
          wasmDir,
          jsDir
        )

        for (dir in targetDirs) {
          if (!dir.exists()) {
            dir.mkdirs()
          }
          dir.setReadable(true, false)
          dir.setWritable(true, false)
          dir.setExecutable(true, false)
        }
      } catch (_: Exception) {}
    }
  }
}
