// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kotlin.compose.compiler) apply false
}

subprojects {
    plugins.withId("com.android.application") {
        configureAndroidJvmCompatibility()
    }
    plugins.withId("com.android.library") {
        configureAndroidJvmCompatibility()
    }
}

fun Project.configureAndroidJvmCompatibility() {
    extensions.configure<com.android.build.gradle.BaseExtension> {
        compileOptions {
            sourceCompatibility = JavaVersion.toVersion(libs.versions.java.get())
            targetCompatibility = JavaVersion.toVersion(libs.versions.java.get())
        }
    }
}