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
    const val kotlinStd = "1.3.31"
    const val appCompat = "1.1.0"
    const val coreKtx = "1.1.0"
    const val constraintLayout = "1.1.3"

    const val jUnit = "4.12"
    const val testRunner = "1.2.0"
    const val espressoCore = "3.2.0"
}

object StandardLibraries {
    const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinStd}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object TestLibaries {
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object ExternalLibaries {

}

object GoogleLibaries {

}
