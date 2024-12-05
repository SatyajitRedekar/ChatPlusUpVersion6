plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
//    id("com.android.application")
//    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.chatplus"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.chatplus"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    dataBinding {
        enable = true
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    implementation(libs.firebase.storage)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")

//    manaual adding of dependancies of firebase

    implementation("com.google.firebase:firebase-database")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation("com.google.android.gms:play-services-auth:21.2.0")

//    implementation("androidx.text.ext:junit")
    implementation("androidx.test.espresso:espresso-core:3.6.1")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
//    implementation("com.mikhaellopez:circularimageview:3.2.0")


//    degine material

    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.25")
    implementation ("com.github.rosenpin:fading-text-view:3.3")
    implementation ("com.squareup.picasso:picasso:2.8")

//    main screen material from internet retrive 31 - 10 - 2024

    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.cardview:cardview:1.0.0")


// Also add the dependency for the Google Play services library and specify its version
    implementation("com.google.android.gms:play-services-auth:21.2.0")
//    implementation("com.github.bumptech.glide:glide:3.7.0")

    implementation("com.google.firebase:firebase-storage")
}