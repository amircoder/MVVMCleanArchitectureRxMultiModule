package com.aba.core.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.aba.core.base.FragmentTestBase
import com.aba.core.domain.data.SearchModel
import com.aba.core.network.ResultResponse
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import org.assertj.core.api.Assertions.assertThat
import org.assertj.android.api.Assertions.assertThat
import org.junit.Before

import org.junit.Test
import org.mockito.MockitoAnnotations.initMocks

class SearchFragmentTest : FragmentTestBase<SearchFragment>(){

    private var mockViewModel: SearchViewModel = mock()
    private var mockViewModelFactory: ViewModelProvider.Factory = mock()

    private val liveData = MutableLiveData<ResultResponse<List<SearchModel>>>()
    private lateinit var viewModel: SearchViewModel
    private lateinit var spyFragment: SearchFragment


    @Before
    fun setUp() {
        initMocks(this)
        setupViewModel()
        setupLiveData()
        createFragment()
        viewModel = spy(fragment.viewModel)
        spyFragment = spy(fragment)
    }

    /*
     * Test
     */

    @Test
    fun `whenOnCreate thenViewIsCreated andThenViewModelIsCreated`(){
        thenViewIsCreated()
        thenViewModelIsCreated()
    }

    private fun thenViewModelIsCreated() {
        assertThat(mockViewModel).isNotNull
    }


    /*
     * Given
     */


    /*
     * Then
     */
    private fun thenViewIsCreated() {
        assertThat(fragment.view).isNotNull
        assertThat(fragment.view).isVisible
    }

    /*
     * Helper
     */
    private fun setupViewModel() {
        given(mockViewModelFactory.create(SearchViewModel::class.java))
            .willReturn(mockViewModel)
    }

    private fun setupLiveData() {
        given(mockViewModel.searchLiveData).willReturn(liveData)
    }
}