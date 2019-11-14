package com.example.rentbike.presentation

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.rentbike.core.functional.ResourceState
import kotlin.math.roundToLong

@BindingAdapter("distance")
fun setDistance(textView: TextView, distance: Float) {
    if (distance < 1000.00) {
        textView.text = distance.roundToLong().toString() + "m"
    } else {
        textView.text = (distance / 1000).roundToLong().toString() + "km"
    }
}
