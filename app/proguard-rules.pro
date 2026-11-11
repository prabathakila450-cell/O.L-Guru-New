# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# Keep all app classes and members to ensure 100% safety with reflection, serialization, and UI
-keep class com.example.** { *; }
-keepclassmembers class com.example.** { *; }

# Ignore missing optional annotations in third-party SDKs (like Facebook Ads)
-dontwarn com.facebook.infer.annotation.**
-dontwarn com.facebook.ads.**


# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

