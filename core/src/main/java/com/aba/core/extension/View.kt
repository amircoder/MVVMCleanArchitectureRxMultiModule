package com.aba.core.extension

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}


fun <VH: RecyclerView.ViewHolder>RecyclerView.setupLinearLayout(adapter: RecyclerView.Adapter<VH>){
    this.layoutManager = LinearLayoutManager(context)
    this.adapter = adapter
    setHasFixedSize(true)
}