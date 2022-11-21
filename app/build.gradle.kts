plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = Versions.ProjectConstants.PACKAGE_NAME
    compileSdk = Versions.ProjectConstants.TARGET_SDK

    defaultConfig {
        applicationId = Versions.ProjectConstants.PACKAGE_NAME
        minSdk = Versions.ProjectConstants.MINIMUM_SDK
        targetSdk = Versions.ProjectConstants.TARGET_SDK
        versionCode = Versions.ProjectConstants.VERSION_CODE
        versionName = Versions.ProjectConstants.VERSION_NAME

        testInstrumentationRunner = Versions.ProjectConstants.TEST_INSTRUMENTATION_RUNNER
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.APP_COMPAT)
    implementation(Dependencies.AndroidX.MATERIAL)
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependencies.AndroidX.FRAGMENT_KTX)
    implementation(Dependencies.AndroidX.ACTIVITY_KTX)
    implementation(Dependencies.AndroidX.PAGING)
    implementation(Dependencies.AndroidX.ROOM_PAGING)
    implementation(Dependencies.AndroidX.ANNOTATION)
    implementation(Dependencies.AndroidX.LEGACY_SUPPPORT)
    implementation(Dependencies.AndroidX.WORK_MANAGER_KTX)
    implementation(Dependencies.AndroidX.SPLASHSCREEN)

    implementation(Dependencies.AndroidX.VIEWMODEL_KTX)
    implementation(Dependencies.AndroidX.LIVEDATA_KTX)
    kapt(Dependencies.AndroidX.LIFECYCLE_PROCESSOR)
    testImplementation(Dependencies.AndroidX.LIFECYCLE_TESTING)

    implementation(Dependencies.Navigation.NAV_UI)
    implementation(Dependencies.Navigation.NAV_FRAGMENT)
    implementation(Dependencies.Navigation.NAV_RUNTIME)

    implementation(Dependencies.Util.TIMBER)
    implementation(Dependencies.Util.GOOGLE_GSON)
    implementation(Dependencies.Util.COIL)

    implementation(Dependencies.Network.GSON_CONVERTER)

    implementation(Dependencies.Kotlin.COROUTINE_ANDROID)
    testImplementation(Dependencies.Kotlin.COROUTINE_TEST)
    androidTestImplementation(Dependencies.Kotlin.COROUTINE_TEST)

    implementation(Dependencies.Hilt.HILT_WORKER)
    implementation(Dependencies.Hilt.HILT_ANDROID)
    kapt(Dependencies.Hilt.HILT_ANDROID_COMPILER)
    kapt(Dependencies.Hilt.HILT_COMPILER)

    testImplementation(Dependencies.Test.TRUTHY)
    testImplementation(Dependencies.Test.JUNIT)
    testImplementation(Dependencies.Test.MOCKK)
    testImplementation(Dependencies.Test.ROBOELECTRIC)
    testImplementation(Dependencies.Test.CORE_TESTING)
    androidTestImplementation(Dependencies.Test.JUNIT_EXT)
    androidTestImplementation(Dependencies.Test.ESPRESSO)
    androidTestImplementation(Dependencies.Test.MOCKK)
    androidTestImplementation(Dependencies.Test.TRUTHY)
    androidTestImplementation(Dependencies.Test.CORE_TESTING)
}