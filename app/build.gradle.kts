plugins {
    alias(libs.plugins.android.application)
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.elegidocodes.androidtest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.elegidocodes.androidtest"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    // Default libraries
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    // ~~~~~ Custom libraries ~~~~~

    // Retrofit for HTTP client
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.gson)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.scalars)

    // Lottie for splash animation
    implementation(libs.lottie)

    // RxJava for Pagination
    implementation(libs.paging.runtime)
    implementation(libs.paging.rxjava3)
    implementation(libs.adapter.rxjava3)

    // Hilt Dagger for dependency injection
    implementation(libs.hilt.android)
    implementation(libs.legacy.support.v4)
    annotationProcessor(libs.hilt.compiler)

    // ViewModel and LiveData for lifecycle
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)

    // Swipe to refresh for pull to refresh
    implementation(libs.swiperefreshlayout)

    // Glide for image loading
    implementation(libs.glide)
    annotationProcessor(libs.compiler)

    // Glide for more custom image loading
    implementation(libs.picasso)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}