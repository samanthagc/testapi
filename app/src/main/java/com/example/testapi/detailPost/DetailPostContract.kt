package com.example.testapi.detailPost

import com.example.testapi.arch.BasePresenter
import com.example.testapi.arch.BaseView
import com.example.testapi.post.model.Post

interface DetailPostContract {

    interface DetailPostView : BaseView {

        fun getPost(post: Post)

    }

    abstract class DetailPostPresenter(
        detailPostView: DetailPostView
    ) : BasePresenter<DetailPostView>(detailPostView){

        abstract fun onItemInteraction(position: Int)
    }
}