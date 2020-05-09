package com.aba.core.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.test.rule.ActivityTestRule
import com.aba.core.TestActivity
import com.aba.core.domain.model.SearchModel
import com.aba.core.network.ResultResponse
import com.aba.search.R
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import org.junit.Before
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations.initMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchListFragmentUITestX {

    private val searchLiveData = MutableLiveData<ResultResponse<List<SearchModel>>>()
    private val mockViewModelFactory: ViewModelProvider.Factory = mock()
    private val mockViewModel: SearchViewModel = mock()

    @get:Rule
    var activityRule: ActivityTestRule<TestActivity>
            = ActivityTestRule(TestActivity::class.java)


    @Before
    fun setup(){
        activityRule.activity.supportFragmentManager.beginTransaction().add(
            R.id.container,
            SearchListFragment()
        )
        initMocks(this)
        setupViewModel()
        setupViewModelState()

    }


    @Test
    fun whenOnCreate_thenViewIsCreated_andThenViewModelIsCreated(){
        thenViewIsCreated()
        thenViewModelIsCreated()
    }




    /*
     * Then
     */
    private fun thenViewIsCreated() {

    }

    private fun thenViewModelIsCreated() {

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