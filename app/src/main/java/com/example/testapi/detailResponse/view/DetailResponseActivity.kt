package com.example.testapi.detailResponse.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.testapi.R
import com.example.testapi.detailResponse.DetailResponseContract
import com.example.testapi.detailResponse.presenter.DetailResponsePresenter
import com.example.testapi.detailResponse.repo.DetailResponseRepo
import com.example.testapi.responseApi.model.ResponseAPI
import kotlinx.android.synthetic.main.activity_detail_response.*
import kotlinx.android.synthetic.main.activity_detail_response.pb_loading
import kotlinx.android.synthetic.main.activity_main.*

class DetailResponseActivity : AppCompatActivity(), DetailResponseContract.DetailResponseView {

    private val presenter : DetailResponseContract.DetailResponsePresenter by lazy{
        DetailResponsePresenter(this, DetailResponseRepo())
    }

    private var idResponseAPI : Int = 0

    override fun getResponse(response: ResponseAPI) {

        id_detail_response.text = "message ${response.id}"
        user_id_detail_response.text = "user ${response.id}"
        title_detail_response.text = response.title
        body_detail_response.text = response.body

    }

    override fun hideLoading() {
        pb_loading.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        updateToolbar()

        setContentView(R.layout.activity_detail_response)
        idResponseAPI = intent.getIntExtra("idItem",0)

        presenter.onItemInteraction(idResponseAPI)
    }

    private fun updateToolbar() {
        val actionbar = supportActionBar
        actionbar!!.title = "Post"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
