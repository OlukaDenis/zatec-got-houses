import org.jetbrains.kotlin.cfg.pseudocode.and

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

        testInstrumentationRunner = "com.zatec.got_houses.HiltTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true
        }

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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.CORE
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
        resources.excludes.add("META-INF/*")
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.APP_COMPAT)
    implementation(Dependencies.AndroidX.MATERIAL)
    implementation(Dependencies.AndroidX.LIFECYCLE)
    implementation(Dependencies.AndroidX.PAGING)
    implementation(Dependencies.AndroidX.ROOM_PAGING)

    implementation(Dependencies.Compose.UI)
    implementation(Dependencies.Compose.PAGING)
    implementation(Dependencies.Compose.MATERIAL_ICONS)
    implementation(Dependencies.Compose.MATERIAL)
    implementation(Dependencies.Compose.UI_PREVIEW)
    implementation(Dependencies.Compose.ACTIVITY)
    implementation(Dependencies.Compose.VIEWMODEL)
    implementation(Dependencies.Compose.NAV)
    implementation(Dependencies.Compose.HILT)
    androidTestImplementation(Dependencies.Compose.UI_TEST)
    debugImplementation(Dependencies.Compose.UI_TOOLING)
    debugImplementation(Dependencies.Compose.MANIFEST_TEST)

    implementation(Dependencies.Util.TIMBER)
    implementation(Dependencies.Util.GOOGLE_GSON)

    implementation(Dependencies.Kotlin.COROUTINE_ANDROID)
    implementation(Dependencies.Kotlin.COROUTINE_CORE)
    testImplementation(Dependencies.Kotlin.COROUTINE_TEST)
    androidTestImplementation(Dependencies.Kotlin.COROUTINE_TEST)

    implementation(Dependencies.Hilt.HILT_WORKER)
    implementation(Dependencies.Hilt.HILT_ANDROID)
    kapt(Dependencies.Hilt.HILT_ANDROID_COMPILER)
    kapt(Dependencies.Hilt.HILT_COMPILER)
    testImplementation(Dependencies.Hilt.HILT_TEST)
    androidTestImplementation(Dependencies.Hilt.HILT_TEST)
    kaptAndroidTest(Dependencies.Hilt.HILT_ANDROID_COMPILER)

    testImplementation(Dependencies.Test.TRUTHY)
    testImplementation(Dependencies.Test.JUNIT)
    testImplementation(Dependencies.Test.MOCKK)
    testImplementation(Dependencies.Test.ROBOELECTRIC)
    testImplementation(Dependencies.Test.CORE_TESTING)
    testImplementation(Dependencies.Test.CORE)
    androidTestImplementation(Dependencies.Test.JUNIT_EXT)
    androidTestImplementation(Dependencies.Test.ESPRESSO)
    androidTestImplementation(Dependencies.Test.MOCKK)
    androidTestImplementation(Dependencies.Test.TRUTHY)
    androidTestImplementation(Dependencies.Test.CORE_TESTING)
    androidTestImplementation(Dependencies.Test.CORE)
    androidTestImplementation(Dependencies.Test.RULES)
    androidTestImplementation(Dependencies.Test.RUNNER)
}