package com.aba.core.di

import com.aba.core.di.scope.PerFragment
import com.aba.core.ui.SearchListFragment
import com.aba.core.ui.list.SearchItemViewHolder
import com.aba.core.ui.list.SearchListAdapter
import com.aba.core.ui.list.SearchListAdapterImpl
import dagger.Module
import dagger.Provides

@Module
class SearchFragmentModule {

    @PerFragment
    @Provides
    fun provideAdapterCallback(searchListFragment: SearchListFragment):
            SearchListAdapter.SearchAdapterCallback = searchListFragment

    @PerFragment
    @Provides
    fun provideAdapter(adapter: SearchListAdapterImpl):
            SearchListAdapter<SearchItemViewHolder> = adapter

}