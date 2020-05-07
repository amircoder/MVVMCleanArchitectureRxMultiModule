package com.aba.core.data.local.datasource

import com.aba.core.*
import com.aba.core.data.local.dao.SearchDao
import com.aba.core.data.local.model.LocalSearchModel
import com.aba.core.data.mapper.LocalSearchMapper
import com.aba.core.data.model.TVSearchResponse
import com.aba.core.domain.model.SearchModel
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchLocalDataSourceImplTest {

    private lateinit var result: TestObserver<List<SearchModel>>
    private val emptyResult = listOf<LocalSearchModel>()
    private val emptySearchResult = listOf<SearchModel>()

    @Mock
    private lateinit var searchDao: SearchDao
    @Mock
    private lateinit var mockMapper: LocalSearchMapper

    @InjectMocks
    private lateinit var subject: SearchLocalDataSourceImpl

    @Before
    fun setup(){
        given(mockMapper.mapFromLocal(any())).willReturn(SOME_SEARCH_MODELS)
        given(mockMapper.mapFromLocal(emptyResult)).willReturn(emptyList())
        given(mockMapper.mapToLocal(any())).willReturn(SOME_LOCAL_SEARCH_MODELS)
    }

    @Test
    fun `givenLocalDataIsAvailable whenOnSearch thenResultIsSuccessful`() {
        givenLocalDataIsAvailable()
        whenOnSearch()
        thenResultIsSuccessful()
        thenSearchDaoGetTvItemsIsCalled()
    }

    @Test
    fun `givenLocalDataIsEmpty whenOnSearch thenResultIsEmpty`() {
        givenLocalDataIsEmpty()
        whenOnSearch()
        thenResultIsEmpty()
        thenSearchDaoGetTvItemsIsCalled()
    }

    @Test
    fun `whenOnInsert thenDataIsInsertedIntoDB`(){
        whenOnInsert()
        thenDataIsInsertedIntoDB()
    }


    /*
     * Given
     */
    private fun givenLocalDataIsAvailable() {
        given(searchDao.getTvItems(SOME_TEXT)).willReturn(
            Observable.just(SOME_LOCAL_SEARCH_MODELS)
        )
    }

    private fun givenLocalDataIsEmpty() {
        given(searchDao.getTvItems(SOME_TEXT)).willReturn(
            Observable.just(emptyResult)
        )
    }


    /*
     * When
     */
    private fun whenOnSearch() {
        result = subject.search(SOME_TEXT).test()
    }

    private fun whenOnInsert() {
        subject.insert(SOME_SEARCH_MODELS)
    }

    /*
     * Then
     */

    private fun thenResultIsSuccessful() = with(result) {
        assertComplete()
            .assertNoErrors()
            .assertValue(SOME_SEARCH_MODELS)
    }

    private fun thenResultIsEmpty() = with(result) {
        assertComplete()
            .assertNoErrors()
            .assertValue(emptySearchResult)
    }

    private fun thenDataIsInsertedIntoDB() {
        verify(searchDao).insert(SOME_LOCAL_SEARCH_MODELS)
    }

    private fun thenSearchDaoGetTvItemsIsCalled() {
        verify(searchDao).getTvItems(SOME_TEXT)
    }
}