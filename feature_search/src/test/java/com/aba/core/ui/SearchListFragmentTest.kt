package com.aba.core.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.aba.core.base.FragmentTestBase
import com.aba.core.domain.model.SearchModel
import com.aba.core.network.ResultResponse
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import org.assertj.android.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations.initMocks

class SearchListFragmentTest: FragmentTestBase<SearchListFragment>() {

    private val mockViewModelFactory: ViewModelProvider.Factory = mock()
    private val mockViewModel: SearchViewModel = mock()

    private val searchLiveData = MutableLiveData<ResultResponse<List<SearchModel>>>()
    private lateinit var spyFragment: SearchListFragment
    private lateinit var spyViewModel: SearchViewModel

    @Before
    fun setup(){
        initMocks(this)
        setupViewModel()
        setupViewModelState()
        createFragment()
        spyFragment = spy(fragment)
        spyViewModel = spy(fragment.viewModel)
    }

    @Test
    fun `whenOnCreate thenViewIsCreated andThenViewModelIsCreated`(){
        thenViewIsCreated()
        thenViewModelIsCreated()
    }


    /*
     * Then
     */
    private fun thenViewModelIsCreated() {
        assertThat(fragment.view).isNotNull
        assertThat(fragment.view).isVisible
    }

    private fun thenViewIsCreated() {
        assertThat(fragment.viewModel).isNotNull
    }


    /*
     * Helper
     */
    private fun setupViewModel() {
        given(mockViewModelFactory.create(SearchViewModel::class.java)).willReturn(mockViewModel)
    }

    private fun setupViewModelState() {
        given(mockViewModel.searchLiveData).willReturn(searchLiveData)
    }

}