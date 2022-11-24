plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.data"
    compileSdk = Versions.ProjectConstants.TARGET_SDK

    defaultConfig {
        minSdk = Versions.ProjectConstants.MINIMUM_SDK
        targetSdk = Versions.ProjectConstants.TARGET_SDK

        testInstrumentationRunner = "com.data.HiltTestRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true

            buildConfigField("String", "BASE_URL", "\"${Versions.BASE_URL}\"")
        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField("String", "BASE_URL", "\"${Versions.BASE_URL}\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    kapt {
        arguments {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }
}

dependencies {

    implementation(Dependencies.AndroidX.DATA_STORE)
    implementation(Dependencies.AndroidX.DATA_STORE_PREFERENCES)
    implementation(Dependencies.ProtoBuf.JAVA_LITE)
    implementation(Dependencies.ProtoBuf.KOTLIN_LITE)

    implementation(Dependencies.AndroidX.VIEWMODEL_KTX)
    implementation(Dependencies.AndroidX.LIVEDATA_KTX)
    kapt(Dependencies.AndroidX.LIFECYCLE_PROCESSOR)
    testImplementation(Dependencies.AndroidX.LIFECYCLE_TESTING)

    implementation(Dependencies.Network.OKHTTP)
    implementation(Dependencies.Network.RETROFIT)
    implementation(Dependencies.Network.GSON_CONVERTER)
    implementation(Dependencies.Network.LOGGING_INTERCEPTOR)
    testImplementation(Dependencies.Network.MOCK_WEB_SERVER)
    androidTestImplementation(Dependencies.Network.MOCK_WEB_SERVER)

    testImplementation(Dependencies.Kotlin.COROUTINE_TEST)
    implementation(Dependencies.Kotlin.COROUTINE_ANDROID)

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
    androidTestImplementation(Dependencies.Test.TRUTHY)
    androidTestImplementation(Dependencies.Test.JUNIT_EXT)
    androidTestImplementation(Dependencies.Test.ESPRESSO)
    androidTestImplementation(Dependencies.Test.CORE_TESTING)

    implementation(Dependencies.AndroidX.PAGING)
    implementation(Dependencies.AndroidX.ROOM_PAGING)
    implementation(Dependencies.Room.RUNTIME)
    implementation(Dependencies.Room.KTX)
    kapt(Dependencies.Room.COMPILER)
    testImplementation(Dependencies.Room.TEST)

    implementation(Dependencies.Util.TIMBER)

    implementation(project(":domain"))
}