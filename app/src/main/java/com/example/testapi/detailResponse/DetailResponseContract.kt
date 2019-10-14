package com.example.testapi.detailResponse

import com.example.testapi.arch.BasePresenter
import com.example.testapi.arch.BaseView
import com.example.testapi.responseApi.model.ResponseAPI

interface DetailResponseContract {

    interface DetailResponseView : BaseView {

        fun getResponse(responseAPI: ResponseAPI)

    }

    abstract class DetailResponsePresenter(
        detailResponseView: DetailResponseView
    ) : BasePresenter<DetailResponseView>(detailResponseView){

        abstract fun onItemInteraction(position: Int)
    }
}