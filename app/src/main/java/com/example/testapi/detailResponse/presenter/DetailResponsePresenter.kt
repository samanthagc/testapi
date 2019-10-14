package com.example.testapi.detailResponse.presenter

import android.util.Log
import com.example.testapi.detailResponse.DetailResponseContract
import com.example.testapi.detailResponse.repo.DetailResponseRepo
import com.example.testapi.responseApi.model.ResponseAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailResponsePresenter(val datailView: DetailResponseContract.DetailResponseView,
                              private val detailResponseRepo: DetailResponseRepo)
    : DetailResponseContract.DetailResponsePresenter(
    datailView
) {


    override fun onItemInteraction(position: Int) {
        launch {
            try{
                val responseApi = detailResponseRepo.getItemSelected(position)
                setItemView(responseApi)
            }catch (e : Exception) {
                Log.i("Erro" , e.message)
            }
        }
    }

    suspend fun setItemView(response : ResponseAPI){
        withContext(Dispatchers.Main) {
            datailView.getResponse(response)
            datailView.hideLoading()
        }
    }


}