buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("io.realm:realm-gradle-plugin:10.15.1")
    }
}

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
    id("com.google.firebase.crashlytics") version "2.9.9" apply false
    id("org.jetbrains.kotlin.kapt") version "1.6.20" apply false
    `kotlin-dsl`
}
