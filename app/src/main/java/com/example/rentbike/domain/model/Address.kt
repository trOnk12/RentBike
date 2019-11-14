package com.example.rentbike.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(val city: String, val street: String, val streetNumber: String) : Parcelable