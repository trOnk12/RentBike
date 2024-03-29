package com.example.rentbike.core.extension

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.isHasPermission(vararg permissions: String): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        permissions.all { singlePermission ->
            applicationContext.checkSelfPermission(singlePermission) == PackageManager.PERMISSION_GRANTED
        }
    else true
}

fun AppCompatActivity.startActivityWithFinish(intent: Intent){
    startActivity(intent)
    finish()
}