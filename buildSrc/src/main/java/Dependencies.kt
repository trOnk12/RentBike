object Versions {
    object DefaultConfig {
        const val compiledSdkVersion = 29
        const val buildToolsVersion = "29.0.2"
        const val applicationId = "com.example.rentbike"
        const val minSdkVersion = 21
        const val targetSdkVersion = 29
        const val versionCode = 1
        const val versinName = "1.0"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Standard {
        const val appCompat = "1.1.0"
        const val coreKtx = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val jUnit = "4.12"
        const val testRunner = "1.2.0"
        const val espressoCore = "3.2.0"
    }

    object External {


    }
}

object Dependencies {
    object Standard {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.Standard.appCompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.Standard.coreKtx}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Standard.constraintLayout}"
        const val jUnit = "junit:junit:${Versions.Standard.jUnit}"
        const val testRunner = "androidx.test:runner:${Versions.Standard.testRunner}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.Standard.espressoCore}"
    }

    object External {

    }
}