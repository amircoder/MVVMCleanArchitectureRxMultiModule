package com.aba.core.ui.list

import androidx.recyclerview.widget.RecyclerView
import com.aba.core.domain.data.SearchModel

abstract class SearchListAdapter<VH: RecyclerView.ViewHolder>: RecyclerView.Adapter<VH>() {

    var searchItems: List<SearchModel> = emptyList()
        set(value) {
           field = value
            notifyDataSetChanged()
        }

    interface SearchAdapterCallback {
        fun onSearchItem(item: SearchModel)
    }

}