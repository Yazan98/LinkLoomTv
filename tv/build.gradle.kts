import java.util.Properties

fun loadProperties(file: File): Properties {
    val properties = Properties()
    if (file.exists()) {
        file.inputStream().use { properties.load(it) }
    }
    return properties
}

// Load properties from local.properties
val localPropertiesFile = rootProject.file("local.properties")
val localProperties = loadProperties(localPropertiesFile)

// Access the properties in your Kotlin build.gradle script
val password: String? by localProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("org.jetbrains.kotlin.kapt")
}

apply(plugin = "realm-android")

android {
    signingConfigs {
        create("release") {
            storeFile = file("../keys/Tv Signing Key")
            storePassword = password
            keyAlias = "key0"
            keyPassword = password
        }
    }

    namespace = "com.yazantarifi.linkloom.tv"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.yazantarifi.linkloom.tv"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.leanback:leanback:1.0.0")
    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation(platform("com.google.firebase:firebase-bom:31.4.0"))

    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.lifecycle:lifecycle-process:2.6.2")
    debugImplementation("androidx.compose.ui:ui-tooling")

    implementation("androidx.tv:tv-foundation:1.0.0-alpha10")
    implementation("androidx.tv:tv-material:1.0.0-alpha10")

    implementation("com.google.android.gms:play-services-cast-tv:21.0.0")
    implementation("com.google.android.gms:play-services-cast:21.3.0")

    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")
}
