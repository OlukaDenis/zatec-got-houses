// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(Dependencies.Navigation.CLASSPATH)
        classpath(Dependencies.Hilt.CLASSPATH)
    }
}


plugins {
    id("com.android.application") version "7.3.1" apply false
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
    id("nl.neotech.plugin.rootcoverage") version "1.6.0"
}
