package com.example.testapi.detailPost.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.testapi.R
import com.example.testapi.detailPost.DetailPostContract
import com.example.testapi.detailPost.presenter.DetailPostPresenter
import com.example.testapi.detailPost.repo.DetailPostRepo
import com.example.testapi.post.model.Post
import kotlinx.android.synthetic.main.activity_detail_post.*
import kotlinx.android.synthetic.main.activity_detail_post.pb_loading

class DetailPostActivity : AppCompatActivity(), DetailPostContract.DetailPostView {

    private val presenter : DetailPostContract.DetailPostPresenter by lazy{
        DetailPostPresenter(this, DetailPostRepo())
    }

    private var idPost : Int = 0

    override fun getPost(post: Post) {

        id_detail_post.text = "message ${post.id}"
        user_id_detail_post.text = "user ${post.id}"
        title_detail_post.text = post.title
        body_detail_post.text = post.body

    }

    override fun hideLoading() {
        pb_loading.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        updateToolbar()

        setContentView(R.layout.activity_detail_post)
        idPost = intent.getIntExtra("idItem",0)

        presenter.onItemInteraction(idPost)
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
