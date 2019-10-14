package com.example.testapi.login.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testapi.R
import com.example.testapi.login.LoginContract
import com.example.testapi.login.model.Login
import com.example.testapi.login.presenter.LoginPresenter
import com.example.testapi.post.view.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    private val presenter : LoginContract.LoginPresenter by lazy {
        LoginPresenter(this)
    }

    override fun getLoginSucess(login: Login) {
        val intent = Intent(this, MainActivity::class.java)

        intent.putExtra("login", login)
        startActivity(intent)
    }

    override fun getLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
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
