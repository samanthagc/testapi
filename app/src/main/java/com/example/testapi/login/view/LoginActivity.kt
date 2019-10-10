package com.example.testapi.login.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testapi.R
import com.example.testapi.login.LoginContract
import com.example.testapi.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    override fun getLoginSucess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun getLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private val presenter : LoginContract.LoginPresenter by lazy {
        LoginPresenter(this)
    }

    override fun hideLoading() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_Login.setOnClickListener {
            presenter.onLogin(edt_name.text.toString(), edt_nickname.text.toString())
        }

    }
}
