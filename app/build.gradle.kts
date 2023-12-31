plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.moviesapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.moviesapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "API_KEY", "\"00bed0fbd177e6629956b2c9d44363fd\"")
        buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
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
        jvmTarget = "1.8"
    }
    buildFeatures{
        dataBinding = true
        buildConfig = true

    }
}

dependencies {


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    //noinspection LifecycleAnnotationProcessorWithJava8
    kapt ("androidx.lifecycle:lifecycle-compiler:2.6.2")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.2")
//
//
    implementation ("androidx.room:room-runtime:2.6.1")
   kapt ("androidx.room:room-compiler:2.6.1")
   implementation("androidx.room:room-ktx:2.6.1")
//
//
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
//
    implementation ("com.google.dagger:dagger:2.50")
   kapt ("com.google.dagger:dagger-compiler:2.50")
//
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
//
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
//
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    implementation ("com.github.bumptech.glide:glide:4.16.0")









}