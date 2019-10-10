package com.example.testapi.responseApi.view.customView

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.example.testapi.R

class DataLoginView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    init{
        inflate(context, R.layout.login_data, this)

        val dataName: TextView = findViewById(R.id.tv_name)
        val dataNickname: TextView = findViewById(R.id.tv_nickname)

        val attributes = context!!.obtainStyledAttributes(attrs, R.styleable.DataLoginView)
        dataName.text = attributes.getString(R.styleable.DataLoginView_name)
        dataNickname.text = attributes.getString(R.styleable.DataLoginView_nickname)
        attributes.recycle()
    }
}