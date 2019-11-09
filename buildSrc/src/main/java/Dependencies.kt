object DefaultConfig {
    const val compiledSdkVersion = 29
    const val buildToolsVersion = "29.0.2"
    const val applicationId = "com.example.rentbike"
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    const val gsonConverter = "2.6.2"
    const val kotlinStd = "1.3.31"
    const val appCompat = "1.1.0"
    const val coreKtx = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val recyclerView = "1.0.0"

    const val jUnit = "4.12"
    const val testRunner = "1.2.0"
    const val espressoCore = "3.2.0"

    const val dagger = "2.25.2"
    const val daggerCompiler = "2.25.2"

    const val retrofit = "2.6.1"
    const val gson = "2.8.6"
    const val httpLoggingInterceptor = "4.2.1"
}

object StandardLibraries {
    const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinStd}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
}

object TestLibaries {
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object ExternalLibaries {
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerCompiler}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.httpLoggingInterceptor}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
}

object GoogleLibaries {

}
