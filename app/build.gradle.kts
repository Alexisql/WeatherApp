plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)
    kotlin("kapt")
    alias(libs.plugins.safe.args)
}

android {
    namespace = "com.alexis.weatherapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.alexis.weatherapp"
        minSdk = 21
        targetSdk = 34
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
            buildConfigField("String", "BASE_URL", "\"https://api.weatherapi.com/\"")
            buildConfigField("String", "API_KEY", "\"de5553176da64306b86153651221606\"")
        }

        debug {
            buildConfigField("String", "BASE_URL", "\"https://api.weatherapi.com/\"")
            buildConfigField("String", "API_KEY", "\"de5553176da64306b86153651221606\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    dataBinding {
        enable = true
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    //DaggerHilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    //Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.logging.interceptor)

    //Splash
    implementation(libs.splash)

    //Glide
    implementation (libs.glide)

    //Test
    testImplementation (libs.mockk)
    testImplementation(libs.junit)
    testImplementation(libs.coroutines.test)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
}