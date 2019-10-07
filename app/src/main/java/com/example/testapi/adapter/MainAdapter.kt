package com.example.testapi.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.testapi.R
import com.example.testapi.model.ResponseAPI
import kotlinx.android.synthetic.main.list_item.view.*

class MainAdapter(
    private val responses: List<ResponseAPI>,
    private val context: Context
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return responses.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val response = responses[position]

        holder.bindView(response)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        var userId: TextView
        var id: TextView
        var title: TextView
        var body: TextView

        init {
            userId = v.user_id_return
            id = v.id_return
            title = v.title_return
            body = v.body_return
        }

        fun bindView(responseAPI: ResponseAPI) {
            userId.text = "user ${responseAPI.userId}"
            id.text = "message ${responseAPI.id}"
            title.text = responseAPI.title
            body.text = responseAPI.body

        }

    }

}