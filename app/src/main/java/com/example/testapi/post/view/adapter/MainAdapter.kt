package com.example.testapi.post.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.testapi.R
import com.example.testapi.post.model.Post
import kotlinx.android.synthetic.main.list_item.view.*

class MainAdapter(
    private val posts: List<Post>,
    private val context: Context,
    itemListener: RecyclerViewClickListener?
    ) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]

        holder.bindView(post)
    }

    interface RecyclerViewClickListener {
        fun recyclerViewListClicked(v: View?, position: Int)
    }

    companion object{
        var itemClickListener: RecyclerViewClickListener? = null
        var postSearchList:List<Post>? = null
    }

    init {
        postSearchList = posts
        itemClickListener = itemListener
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        var userId: TextView
        var id: TextView
        var title: TextView
        var body: TextView
        var idPost : Int = 0

        init {
            userId = v.user_id_return
            id = v.id_return
            title = v.title_return
            body = v.body_return
            v.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            itemClickListener?.recyclerViewListClicked(view, idPost)
        }

        fun bindView(post: Post) {
            userId.text = "user ${post.userId}"
            id.text = "message ${post.id}"
            title.text = post.title
            body.text = post.body
            idPost = post.id
        }

    }

}