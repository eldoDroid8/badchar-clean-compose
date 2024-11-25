plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.compose.compiler)
}

android {
    namespace = "com.ev.badchar"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ev.badchar"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    kotlin {
        jvmToolchain(21)
    }
    buildFeatures {
        compose = true
        buildConfig = true
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.dagger.hilt)
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(libs.androidx.navigation.compose)
    implementation (libs.androidx.hilt.navigation.compose)
    ksp(libs.dagger.hilt.compiler)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.moshi)
    implementation(libs.okhttp)
    implementation(libs.okhttp.inreceptor)
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.mockk)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}