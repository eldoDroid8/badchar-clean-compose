plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.ev.badchar.data"
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes  += "META-INF/DEPENDENCIES"
            excludes  +="META-INF/LICENSE"
            excludes  +="META-INF/LICENSE.md"
            excludes  +="META-INF/LICENSE.txt"
            excludes  +="META-INF/license.txt"
            excludes  +="META-INF/NOTICE.md"
            excludes  +="META-INF/NOTICE.txt"
            excludes  +="META-INF/notice.txt"
            excludes  +="META-INF/ASL2.0"
            excludes  +="META-INF/*.kotlin_module"
            excludes += "META-INF/LICENSE-notice.md"
        }
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":domain"))
    testImplementation(libs.junit)
    testImplementation(libs.assertk)
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.moshi)
    implementation(libs.okhttp)
    implementation(libs.okhttp.inreceptor)
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.mockk)
}