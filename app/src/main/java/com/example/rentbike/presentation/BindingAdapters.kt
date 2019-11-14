package com.example.rentbike.presentation

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("distance")
fun setDistance(textView: TextView, distance: Float) {
    if (distance < 1000.00) {
        textView.text = String.format("%.2f m",distance)
    } else {
        textView.text = String.format("%.2f km",(distance/1000))
    }
}
