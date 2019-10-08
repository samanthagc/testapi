package com.example.testapi.responseApi

import com.example.testapi.arch.BasePresenter
import com.example.testapi.arch.BaseView
import com.example.testapi.responseApi.model.ResponseAPI

interface MainContract {


    interface MainView : BaseView {

        fun getList(list : List<ResponseAPI>)

    }

    abstract class MainPresenter(
        mainView: MainView
    ) : BasePresenter<MainView>(mainView){

        abstract fun getListApi()
    }


}