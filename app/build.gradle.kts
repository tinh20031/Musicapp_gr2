plugins {
    alias(libs.plugins.android.application)
<<<<<<< HEAD
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.musicapp_gr2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.musicapp_gr2"
        minSdk = 33
=======
}

android {
    namespace = "com.example.explorepage"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.explorepage"
        minSdk = 24
>>>>>>> 9d2149f (Explore Page)
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
<<<<<<< HEAD
    implementation(libs.firebase.auth)
=======
>>>>>>> 9d2149f (Explore Page)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}