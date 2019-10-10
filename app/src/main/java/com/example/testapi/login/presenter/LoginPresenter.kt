package com.example.testapi.login.presenter

import com.example.testapi.login.LoginContract
import com.example.testapi.login.model.Login

class LoginPresenter(private val loginView: LoginContract.LoginView) : LoginContract.LoginPresenter(
    loginView
)  {

    override fun onLogin(nome: String, apelido: String) {
        val login = Login(nome, apelido)

        when (login.isDataValid()){
            0 -> loginView.getLoginError("O nome deve ser preenchido.")
            1 -> loginView.getLoginError("O apelido deve ser preenchido")
            -1 -> loginView.getLoginSucess("Logou!!!!!")
        }

    }

}