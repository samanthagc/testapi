package com.example.testapi.login

import com.example.testapi.arch.BasePresenter
import com.example.testapi.arch.BaseView
import com.example.testapi.login.model.Login

interface LoginContract {

    interface LoginView : BaseView {

        fun getLoginSucess(login: Login)
        fun getLoginError(message: String)

    }

    abstract class LoginPresenter(
        loginView: LoginView
    ) : BasePresenter<LoginView>(loginView){

        abstract fun onLogin(name: String, nickname: String)

    }

}