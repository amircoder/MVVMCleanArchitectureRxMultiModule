package com.aba.core.ui.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SearchListAdapterImpl(private val callback: SearchListAdapter.SearchAdapterCallback) : SearchListAdapter<SearchItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchItemViewHolder.create(parent, callback)

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {

    }
}