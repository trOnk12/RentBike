package com.example.rentbike

import android.app.Application
import com.example.rentbike.core.di.ApplicationComponent
import com.example.rentbike.core.di.DaggerApplicationComponent
import com.example.rentbike.core.di.modules.AppModule

class AndroidApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()

    }

    private fun injectMembers() {
        appComponent.inject(this)
    }

}