package com.example.testapi.login.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Login(val nameUser : String, val nicknameUser : String) : Parcelable