plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.ev.badchar.domain"
    compileSdk = 34

    defaultConfig {
        minSdk = 27
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
    kotlinOptions {
        jvmTarget = "21"
    }
    kotlin {
        jvmToolchain(21)
    }
}

dependencies {
    testImplementation(libs.junit)
    testImplementation(libs.assertk)
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
}