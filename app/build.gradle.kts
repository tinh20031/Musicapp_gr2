plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.musicapp_gr2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.musicapp_gr2"
        minSdk = 33
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation (libs.glide)

    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")
    implementation (libs.retrofit)
    implementation (libs.okhttp3.logging.interceptor)
        implementation (libs.picasso)

    implementation (libs.converter.gson)
    implementation (libs.glide.transformations)
    implementation (libs.lottie)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}