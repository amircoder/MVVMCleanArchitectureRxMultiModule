package com.aba.core.ui.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

class SearchListAdapterImpl @Inject constructor(private val callback: SearchListAdapter.SearchAdapterCallback) : SearchListAdapter<SearchItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchItemViewHolder.create(parent, callback)

    override fun getItemCount() = searchItems.size

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        holder.bindView(searchItems[position])
    }
}