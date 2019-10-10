package com.example.testapi.login.presenter

import android.text.TextUtils
import com.example.testapi.login.LoginContract
import com.example.testapi.login.model.Login

class LoginPresenter(private val loginView: LoginContract.LoginView) : LoginContract.LoginPresenter(
    loginView
)  {

    override fun onLogin(name: String, nickname: String) {
        val login = Login(name, nickname)

        when (isDataValid(name, nickname)){
            0 -> loginView.getLoginError("O nome deve ser preenchido.")
            1 -> loginView.getLoginError("O apelido deve ser preenchido")
            2 -> loginView.getLoginError("O apelido deve ser curto")
            -1 -> loginView.getLoginSucess(login)
        }

    }

    fun isDataValid(name: String, nickname: String) : Int {
        return if (TextUtils.isEmpty(name)){
            0 //campo nome nulo
        } else if (TextUtils.isEmpty(nickname)){
            1 //campo apelido nulo
        } else if (nickname.length > 12){
            2 //apelido exagerado
        } else -1
    }

}