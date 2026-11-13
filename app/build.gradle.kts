plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.aistudio.studentportal.slnotes.mqvsiz"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.aistudio.studentportal.slnotes.mqvsiz"
        minSdk = 21
        targetSdk = 35
        versionCode = 3
        versionName = "1.2"
    }
}
