package com.example.rentbike.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(
    var street: String,
    var city: String
) : Parcelable