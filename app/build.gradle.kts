plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dev.flutter.flutter-gradle-plugin")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.aistudio.studentportal.slnotes.mqvsiz"
    compileSdk = flutter.compileSdkVersion.toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    defaultConfig {
        applicationId = "com.aistudio.studentportal.slnotes.mqvsiz"
        minSdk = 21
        targetSdk = flutter.targetSdkVersion.getVersionCode()
        versionCode = flutter.versionCode.toInt()
        versionName = flutter.versionName
    }
}

flutter {
    source = "../.."
}
