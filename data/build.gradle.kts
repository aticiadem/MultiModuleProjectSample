plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = Sdk.compile

    defaultConfig {
        minSdk = Sdk.min
        targetSdk = Sdk.target

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        jvmTarget = Jvm.target
    }
}

dependencies {

    implementation("javax.inject:javax.inject:${Jvm.inject}")

    // Testing
    implementation("junit:junit:${Testing.junit}")
    implementation("androidx.test.ext:junit:${Testing.junitExt}")
    implementation("androidx.test.espresso:espresso-core:${Testing.espresso}")
}