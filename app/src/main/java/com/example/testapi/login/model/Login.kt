package com.example.testapi.login.model

import android.text.TextUtils

class Login(private val nome : String, private val apelido : String){

    fun isDataValid() : Int {
        return if (TextUtils.isEmpty(nome)){
            0 //campo nome nulo
        } else if (TextUtils.isEmpty(apelido)){
            1 //campo apelido nulo
        } else -1
    }

}