package com.example.testapi.responseApi.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.example.testapi.R
import com.example.testapi.detailResponse.view.DetailResponseActivity
import com.example.testapi.login.model.Login
import com.example.testapi.responseApi.MainContract
import com.example.testapi.responseApi.model.ResponseAPI
import com.example.testapi.responseApi.presenter.MainPresenter
import com.example.testapi.responseApi.repo.MainRepo
import com.example.testapi.responseApi.view.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login_data.*

class MainActivity : AppCompatActivity(), MainContract.MainView, MainAdapter.RecyclerViewClickListener {

    private val presenter : MainContract.MainPresenter by lazy{
        MainPresenter(this, MainRepo())
    }

    fun getUserLogin() {
        val login : Login = intent.getParcelableExtra("login")

        tv_name.text =  "User: ${login.nameUser}"
        tv_nickname.text = "Nickname: ${login.nicknameUser}"
    }

    override fun getItemSelected(position: Int) {
        val intent = Intent(this, DetailResponseActivity::class.java)

        intent.putExtra("idItem", position)
        startActivity(intent)
    }

    override fun getList(list: List<ResponseAPI>) {

        val recyclerView = list_return
        recyclerView.adapter = MainAdapter(list, this, this) //TODO Implementar item listener

        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

    }

    override fun hideLoading() {
        pb_loading.visibility = View.GONE
    }

    override fun recyclerViewListClicked(v: View?, position: Int) {
        presenter.onItemInteraction(position)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getListApi()
        getUserLogin()

    }

}
