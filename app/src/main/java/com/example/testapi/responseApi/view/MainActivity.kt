package com.example.testapi.responseApi.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.testapi.R
import com.example.testapi.responseApi.MainContract
import com.example.testapi.responseApi.model.ResponseAPI
import com.example.testapi.responseApi.presenter.MainPresenter
import com.example.testapi.responseApi.repo.MainRepo
import com.example.testapi.responseApi.view.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MainView {


    private val presenter : MainContract.MainPresenter by lazy{
        MainPresenter(this, MainRepo())
    }

    override fun getList(list: List<ResponseAPI>) {

        val recyclerView = list_return
        recyclerView.adapter = MainAdapter(list, this)

        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getListApi()

    }



}
