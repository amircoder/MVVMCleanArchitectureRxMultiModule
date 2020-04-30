package com.aba.core.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aba.core.domain.data.SearchModel
import com.aba.search.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_seach.view.*

class SearchItemViewHolder(override val containerView: View,
                           private val callback: SearchListAdapter.SearchAdapterCallback):
    RecyclerView.ViewHolder(containerView), LayoutContainer {


    companion object {
        fun create(
            parent: ViewGroup,
            callback: SearchListAdapter.SearchAdapterCallback
            ): SearchItemViewHolder = SearchItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_seach, parent, false
                ), callback
        )
    }

    fun bindView(item: SearchModel){
        itemView.searchTitle.text = item.name
        itemView.setOnClickListener {
            callback.onSearchItem(item)
        }
    }

}