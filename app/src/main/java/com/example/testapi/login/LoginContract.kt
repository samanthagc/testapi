package com.example.testapi.login

import com.example.testapi.arch.BasePresenter
import com.example.testapi.arch.BaseView

interface LoginContract {

    interface LoginView : BaseView {

        fun getLoginSucess(message: String)
        fun getLoginError(message: String)

    }

    abstract class LoginPresenter(
        loginView: LoginView
    ) : BasePresenter<LoginView>(loginView){

        abstract fun onLogin(nome: String, apelido: String)

    }

}