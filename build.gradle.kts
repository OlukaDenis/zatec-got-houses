// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val compose_ui_version by extra("1.1.1")
    dependencies {
        classpath(Dependencies.Navigation.CLASSPATH)
        classpath(Dependencies.Hilt.CLASSPATH)
    }
}

plugins {
    id("com.android.application") version "7.3.1" apply false
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
    id("nl.neotech.plugin.rootcoverage") version "1.6.0"
}


rootCoverage {
    excludes = listOf(
        "android/databinding/**/*.class",
        "**/android/databinding/*Binding.class",
        "**/android/databinding/*",
        "**/androidx/databinding/*",
        "**/BR.*",
        "**/R.class",
        "**/R$*.class",
        "**/BuildConfig.*",
        "**/Manifest*.*",
        "**/*Test*.*",
        "android/**/*.*",
        "**/*_MembersInjector.class",
        "**/Dagger*Component.class",
        "**/Dagger*Component*.class",
        "**/Dagger*Subcomponent*.class",
        "**/*Subcomponent*.class",
        "**/*Module_*Factory.class",
        "**/di/module/*",
        "**/*_Factory*.*",
        "**/*Module*.*",
        "**/*Dagger*.*",
        "**/*Hilt*.*",
        "**/*MapperImpl*.*",
        "**/BuildConfig.*",
        "**/*Component*.*",
        "**/*BR*.*",
        "**/Manifest*.*",
        "**/*Companion*.*",
        "**/*Module*.*",
        "**/*Dagger*.*",
        "**/*Hilt*.*",
        "**/*MembersInjector*.*",
        "**/*_MembersInjector.class",
        "**/*_Factory*.*",
        "**/*_Provide*Factory*.*",
        "**/*_Impl*.*",
        "**/*_MyApp*.*",
        "**/*_GeneratedInjector*.*",
        "**/*Database*.*",

        "**/*Theme*.*",
        "**/*Color*.*",
        "**/*Type*.*",
        "**/*Color*.*",
        "**/*Shape*.*",
        "**/*Screen*.*",

        "**/*Mediator*.*",

        "**/*Extensions*.*",
        "**/*Resource*.*",
        "**/*BaseState*.*",
        "**/*$Result.*",
        "**/*$Result$*.*",
        "**/*JsonAdapter.*",
        "**/*BaseSuspendUseCase*.*",
        "**/*BaseFlowUseCase*.*"
    )
}