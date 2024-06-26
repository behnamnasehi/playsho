plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.playsho.android"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.playsho.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }



    kotlinOptions {
        jvmTarget = "1.8"
    }


    buildFeatures {
        dataBinding = true
        viewBinding = true

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
    packaging {
        resources {
            excludes +="META-INF/rxjava.properties"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.core:core-splashscreen:1.1.0-rc01")

    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")
    implementation("com.squareup.retrofit2:adapter-rxjava:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.12")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.12")

    implementation("androidx.datastore:datastore-preferences:1.0.0")

    implementation("androidx.media3:media3-exoplayer:1.2.1")
    implementation("androidx.media3:media3-ui:1.2.1")
    implementation("androidx.media3:media3-exoplayer-dash:1.2.1")

    implementation("com.squareup.picasso:picasso:2.71828")

    implementation("com.github.razir.progressbutton:progressbutton:2.1.0")

    implementation("androidx.annotation:annotation-jvm:1.7.1")

    implementation("io.socket:socket.io-client:2.0.0") {
        exclude(group = "org.json", module = "json")
    }

}