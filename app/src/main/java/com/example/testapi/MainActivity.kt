package com.example.testapi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import com.example.testapi.adapter.MainAdapter
import com.example.testapi.model.ResponseAPI
import com.example.testapi.retrofit.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val call = RetrofitInitializer().responseService().list()
        call.enqueue(object: Callback<List<ResponseAPI>?> {
            override fun onFailure(call: Call<List<ResponseAPI>?>, t: Throwable) {
                Log.e("onFailureError Call API", t.message)
            }

            override fun onResponse(call: Call<List<ResponseAPI>?>, response: Response<List<ResponseAPI>?>) {
                response.body()?.let {
                    val responses : List<ResponseAPI> = it
                    configureList(responses)
                }
            }

        })

    }

    private fun configureList(responses : List<ResponseAPI>) {
        val recyclerView = list_return
        recyclerView.adapter = MainAdapter(responses, this)

        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }


}
