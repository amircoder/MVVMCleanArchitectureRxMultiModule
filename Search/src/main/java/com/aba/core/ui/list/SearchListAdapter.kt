package com.aba.core.ui.list

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.aba.core.domain.model.SearchModel

abstract class SearchListAdapter<VH: RecyclerView.ViewHolder>: RecyclerView.Adapter<VH>() {

    var searchItems: List<SearchModel> = emptyList()
        set(value) {
           field = value
            notifyDataSetChanged()
            Log.d("testTag", "item size in list: ${value.size}")
        }

    interface SearchAdapterCallback {
        fun onSearchItem(item: SearchModel)
    }

}