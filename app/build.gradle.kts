plugins {
    id("com.android.application") version "8.5.0"
    id("org.jetbrains.kotlin.android") version "1.9.24"
    id("com.google.gms.google-services") version "4.4.2"
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
