package com.example.testapi.post

import com.example.testapi.arch.BasePresenter
import com.example.testapi.arch.BaseView
import com.example.testapi.post.model.Post

interface MainContract {


    interface MainView : BaseView {

        fun getList(list : List<Post>)
        fun getItemSelected(position: Int)

    }

    abstract class MainPresenter(
        mainView: MainView
    ) : BasePresenter<MainView>(mainView){

        abstract fun getListApi()
        abstract fun onItemInteraction(position: Int)
    }


}