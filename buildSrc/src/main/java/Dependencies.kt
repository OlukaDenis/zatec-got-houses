object Dependencies {
    object Gradle {
        const val GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE}"
        const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN_STDLIB}"
        const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_STDLIB}"
    }

    object Kotlin {
        const val COROUTINE_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.COROUTINES}"
        const val COROUTINE_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.COROUTINES}"
        const val COROUTINE_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Kotlin.COROUTINES}"
        const val COROUTINES_PLAY_SERVICE = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.Kotlin.COROUTINES}"
    }

    object Compose {
        const val UI = "androidx.compose.ui:ui:${Versions.Compose.CORE}"
        const val MATERIAL = "androidx.compose.material:material:${Versions.Compose.CORE}"
        const val UI_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.CORE}"
        const val UI_TEST = "androidx.compose.ui:ui-test-junit4:${Versions.Compose.CORE}"
        const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.Compose.CORE}"
        const val MANIFEST_TEST = "androidx.compose.ui:ui-test-manifest:${Versions.Compose.CORE}"
        const val MATERIAL_ICONS = "androidx.compose.material:material-icons-extended:${Versions.Compose.CORE}"
        const val PAGING = "androidx.paging:paging-compose:${Versions.Compose.PAGING}"
        const val ACTIVITY = "androidx.activity:activity-compose:${Versions.Compose.ACTIVITY_COMPOSE}"
        const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.VIEWMODEL}"
        const val NAV = "androidx.navigation:navigation-compose:${Versions.Compose.NAVIGATION}"
        const val HILT = "androidx.hilt:hilt-navigation-compose:${Versions.Compose.HILT}"
    }

    object Ktlint {
        const val CLASSPATH = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.Ktlint.GRADLE}"
        const val PLUGIN_NAME = "org.jlleitschuh.gradle.ktlint"
        const val GIT_HOOK = "plugins.git-hook"
    }

    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APP_COMPAT}"
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.AndroidX.CORE_KTX}"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.AndroidX.FRAGMENT_KTX}"
        const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.AndroidX.ACTIVITY_KTX}"
        const val MATERIAL = "com.google.android.material:material:${Versions.AndroidX.MATERIAL}"
        const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.LIFECYCLE_KTX}"
        const val LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidX.LIFECYCLE_KTX}"
        const val LIFECYCLE_PROCESSOR = "androidx.lifecycle:lifecycle-compiler:${Versions.AndroidX.LIFECYCLE_KTX}"
        const val LIFECYCLE_TESTING = "androidx.lifecycle:lifecycle-runtime-testing:${Versions.AndroidX.LIFECYCLE_KTX}"
        const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime:${Versions.AndroidX.LIFECYCLE_KTX}"
        const val WORK_MANAGER_KTX = "androidx.work:work-runtime-ktx:${Versions.AndroidX.WORK_MANAGER_KTX}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.CONSTRAINT_LAYOUT}"
        const val VIEW_PAGER = "androidx.viewpager2:viewpager2:${Versions.AndroidX.VIEW_PAGER}"
        const val DATA_STORE = "androidx.datastore:datastore:${Versions.AndroidX.DATA_STORE}"
        const val DATA_STORE_PREFERENCES = "androidx.datastore:datastore-preferences:${Versions.AndroidX.DATA_STORE}"
        const val PAGING = "androidx.paging:paging-runtime:${Versions.AndroidX.PAGING}"
        const val ROOM_PAGING = "androidx.room:room-paging:${Versions.AndroidX.ROOM}"
        const val EMOJI = "androidx.emoji:emoji:${Versions.AndroidX.EMOJI}"
        const val EMOJI_BUNDLED = "androidx.emoji:emoji-bundled:${Versions.AndroidX.EMOJI_COMPAT}"
        const val EMOJI_COMPAT = "androidx.emoji:emoji-appcompat:${Versions.AndroidX.EMOJI_COMPAT}"
        const val ANNOTATION = "androidx.annotation:annotation:${Versions.AndroidX.ANNOTATION}"
        const val LEGACY_SUPPPORT = "androidx.legacy:legacy-support-v4:${Versions.AndroidX.LEGACY}"
        const val START_UP_X = "androidx.startup:startup-runtime:${Versions.AndroidX.START_UP}"
        const val SPLASHSCREEN = "androidx.core:core-splashscreen:${Versions.AndroidX.SPLASHSCREEN}"
    }

    object Test {
        const val CORE = "androidx.test:core:${Versions.Test.CORE}"
        const val RULES = "androidx.test:rules:${Versions.Test.CORE}"
        const val JUNIT = "junit:junit:${Versions.Test.JUNIT}"
        const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.Test.JUNIT_EXT}"
        const val JACOCO = "org.jacoco:org.jacoco.core:${Versions.Test.JACOCO}"
        const val TRUTHY = "com.google.truth:truth:${Versions.Test.TRUTHY}"
        const val MOCKK = "io.mockk:mockk:${Versions.Test.MOCKK}"
        const val JACOCO_ANDROID = "com.dicedmelon.gradle:jacoco-android:${Versions.Test.JACOCO_ANDROID}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.Test.ESPRESSO}"
        const val CORE_TESTING = "androidx.arch.core:core-testing:${Versions.Test.CORE_TESTING}"
        const val ROBOELECTRIC = "org.robolectric:robolectric:${Versions.Test.ROBOELECTRIC}"
    }

    object Navigation {
        const val NAV_UI = "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.NAVIGATION}"
        const val NAV_RUNTIME = "androidx.navigation:navigation-runtime-ktx:${Versions.AndroidX.NAVIGATION}"
        const val NAV_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidX.NAVIGATION}"
        const val FEATURE_MODULE = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.AndroidX.NAVIGATION}"
        const val TESTING = "androidx.navigation:navigation-testing:${Versions.AndroidX.NAVIGATION}"
        const val CLASSPATH = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.AndroidX.NAVIGATION}"
    }

    object Hilt {
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.Hilt.HILT_CORE}"
        const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.Hilt.HILT_CORE}"
        const val HILT_COMPILER = "androidx.hilt:hilt-compiler:${Versions.Hilt.HILT_COMPILER}"
        const val HILT_TEST = "com.google.dagger:hilt-android-testing:${Versions.Hilt.HILT_CORE}"
        const val CLASSPATH = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Hilt.HILT_CORE}"
        const val HILT_WORKER = "androidx.hilt:hilt-work:${Versions.Hilt.HILT_COMPILER}"
    }

    object Room {
        const val KTX = "androidx.room:room-ktx:${Versions.AndroidX.ROOM}"
        const val RUNTIME = "androidx.room:room-runtime:${Versions.AndroidX.ROOM}"
        const val COMPILER = "androidx.room:room-compiler:${Versions.AndroidX.ROOM}"
        const val TEST = "androidx.room:room-testing:${Versions.AndroidX.ROOM}"
    }

    object Network {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.Network.RETROFIT}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.Network.OKHTTP}"
        const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.Network.OKHTTP}"
        const val GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.Network.RETROFIT}"
        const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:${Versions.Network.OKHTTP}"
    }

    object ProtoBuf {
        const val CLASSPATH = "com.google.protobuf:protobuf-gradle-plugin:${Versions.ProtoBuf.PLUGIN}"
        const val JAVA_LITE = "com.google.protobuf:protobuf-javalite:${Versions.ProtoBuf.CORE}"
        const val KOTLIN_LITE = "com.google.protobuf:protobuf-kotlin-lite:${Versions.ProtoBuf.CORE}"
        const val ARTIFACT = "com.google.protobuf:protoc:${Versions.ProtoBuf.ARTIFACT}"
    }

    object Util {
        const val COIL = "io.coil-kt:coil:${Versions.Utils.COIL}"
        const val PAGER_INDICATOR = "com.romandanylyk:pageindicatorview:${Versions.Utils.PAGE_INDICATOR}"
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.Utils.TIMBER}"
        const val GOOGLE_GSON = "com.google.code.gson:gson:${Versions.Utils.GOOGLE_GSON}"
    }
}