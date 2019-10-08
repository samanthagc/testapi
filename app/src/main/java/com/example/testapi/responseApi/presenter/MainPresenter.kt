package com.example.testapi.responseApi.presenter

import android.util.Log
import com.example.testapi.responseApi.MainContract
import com.example.testapi.responseApi.model.ResponseAPI
import com.example.testapi.responseApi.repo.MainRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainPresenter(val mainView: MainContract.MainView , private val mainRepo: MainRepo) : MainContract.MainPresenter(
    mainView
) {


    override fun getListApi() {

        launch {

            try{

                val list =  mainRepo.getList()

                setListView(list)

            }catch (e : Exception) {
                Log.i("Teste" , e.message)
            }

        }
    }


    suspend fun setListView(list : List<ResponseAPI>){
        withContext(Dispatchers.Main) {
            mainView.getList(list)
        }
    }


//        val call = RetrofitInitializer().responseService().list()
//        call.enqueue(object: Callback<List<ResponseAPI>?> {
//            override fun onFailure(call: Call<List<ResponseAPI>?>, t: Throwable) {
//                Log.e("onFailureError Call API", t.message)
//            }
//
//            override fun onResponse(call: Call<List<ResponseAPI>?>, response: Response<List<ResponseAPI>?>) {
//                response.body()?.let {
//                    val responses : List<ResponseAPI> = it
//                    configureList(responses)
//                }
//            }
//
//        })

}