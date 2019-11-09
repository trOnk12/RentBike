package com.example.rentbike.core.platform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rentbike.AndroidApplication
import com.example.rentbike.core.di.ApplicationComponent

abstract class BaseActivity : AppCompatActivity() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (this.application as AndroidApplication).appComponent
    }

}