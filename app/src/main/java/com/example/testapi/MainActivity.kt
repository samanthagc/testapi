package com.example.testapi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import com.example.testapi.adapter.MainAdapter
import com.example.testapi.model.ResponseAPI
import com.example.testapi.retrofit.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job : Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
        setContentView(R.layout.activity_main)


        GlobalScope.launch {

            getList()?.let { configureList(it) }

        }

    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    private fun configureList(responses : List<ResponseAPI>) {

        this@MainActivity.runOnUiThread {
            val recyclerView = list_return
            recyclerView.adapter = MainAdapter(responses, this)

            val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            recyclerView.layoutManager = layoutManager
        }

    }

    suspend fun getList() : List<ResponseAPI>?{
        return try {
            RetrofitInitializer().responseService().list()
        }catch (e : Exception) {
            Log.i("Erro", e.message)
            null
        }

    }


}
