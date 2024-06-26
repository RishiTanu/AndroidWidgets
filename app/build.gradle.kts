plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.androidcomponents"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidcomponents"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // ViewPager2
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("com.hbb20:ccp:2.5.3")
    implementation ("com.googlecode.libphonenumber:libphonenumber:8.12.48")
   // implementation ("com.github.skydoves:powerspinner:1.2.7")

  //  implementation ("com.github.AnuraganuPunalur:Multi-Selection-Spinner-Android:1.0")

   // implementation ("com.toptoche.searchablespinner:searchablespinnerlibrary:1.3.1")
   // implementation ("com.github.zeeshan5422:Material-MultiSelection-Spinner:0.0.1")
    implementation ("com.github.Liocoder24x7:Advanced-Spinner:v1.0")
    implementation ("com.github.pratikbutani:MultiSelectSpinner:1.0.1")
   // implementation ("androidx.recyclerview:recyclerview:1.3.2")
   // implementation ("com.facebook.shimmer:shimmer:0.5.0")
  /*  //implementation 'com.toptoche.searchablespinner:searchablespinnerlibrary:1.3.1'
    implementation 'androidx.recyclerview:recyclerview:1.2.1'
    implementation 'com.facebook.shimmer:shimmer:0.5.0'*/

}