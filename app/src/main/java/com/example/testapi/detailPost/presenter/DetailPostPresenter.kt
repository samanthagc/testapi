package com.example.testapi.detailPost.presenter

import android.util.Log
import com.example.testapi.detailPost.DetailPostContract
import com.example.testapi.detailPost.repo.DetailPostRepo
import com.example.testapi.post.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailPostPresenter(val datailView: DetailPostContract.DetailPostView,
                          private val detailPostRepo: DetailPostRepo)
    : DetailPostContract.DetailPostPresenter(
    datailView
) {


    override fun onItemInteraction(position: Int) {
        launch {
            try{
                val post = detailPostRepo.getItemSelected(position)
                setItemView(post)
            }catch (e : Exception) {
                Log.i("Erro" , e.message)
            }
        }
    }

    suspend fun setItemView(post : Post){
        withContext(Dispatchers.Main) {
            datailView.getPost(post)
            datailView.hideLoading()
        }
    }


}