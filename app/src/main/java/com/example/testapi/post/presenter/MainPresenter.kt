package com.example.testapi.post.presenter

import android.util.Log
import com.example.testapi.post.MainContract
import com.example.testapi.post.model.Post
import com.example.testapi.post.repo.MainRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(val mainView: MainContract.MainView , private val mainRepo: MainRepo) : MainContract.MainPresenter(
    mainView
) {

    override fun onItemInteraction(position: Int) {
        launch {
            try {
                setItemView(position)
            } catch (e: Exception) {
                Log.i("Erro" , e.message)
            }
        }

    }

    override fun getListApi() {
        launch {
            try{
                val list = mainRepo.getList()
                setListView(list)
            }catch (e : Exception) {
                Log.i("Erro" , e.message)
            }
        }
    }

    suspend fun setListView(list : List<Post>){
        withContext(Dispatchers.Main) {
            mainView.getList(list)
            mainView.hideLoading()
        }
    }

    suspend fun setItemView(position: Int){
        withContext(Dispatchers.Main){
            mainView.getItemSelected(position)
        }
    }

}