package com.example.testapi.responseApi.presenter

import android.util.Log
import com.example.testapi.responseApi.MainContract
import com.example.testapi.responseApi.model.ResponseAPI
import com.example.testapi.responseApi.repo.MainRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(val mainView: MainContract.MainView , private val mainRepo: MainRepo) : MainContract.MainPresenter(
    mainView
) {

    override fun getListApi() {
        launch {
            try{
                val list =  mainRepo.getList()
                setListView(list)
            }catch (e : Exception) {
                Log.i("Erro" , e.message)
            }
        }
    }

    suspend fun setListView(list : List<ResponseAPI>){
        withContext(Dispatchers.Main) {
            mainView.getList(list)
            mainView.hideLoading()
        }
    }

}