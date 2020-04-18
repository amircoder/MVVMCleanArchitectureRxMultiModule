package com.aba.core.data.local.datasource

import com.SOME_SEARCH_RESPONSE_ITEMS
import com.SOME_TEXT
import com.aba.core.data.local.dao.SearchDao
import com.aba.core.data.model.TVSearchResponse
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchLocalDataSourceImplTest {

    private lateinit var result: TestObserver<List<TVSearchResponse>>
    private val emptyResult = listOf<TVSearchResponse>()

    @Mock
    private lateinit var searchDao: SearchDao

    @InjectMocks
    private lateinit var subject: SearchLocalDataSourceImpl


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
            Observable.just(SOME_SEARCH_RESPONSE_ITEMS)
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
        subject.insert(SOME_SEARCH_RESPONSE_ITEMS)
    }

    /*
     * Then
     */

    private fun thenResultIsSuccessful() = with(result) {
        assertComplete()
            .assertNoErrors()
            .assertValue(SOME_SEARCH_RESPONSE_ITEMS)
    }

    private fun thenResultIsEmpty() = with(result) {
        assertComplete()
            .assertNoErrors()
            .assertValue(emptyResult)
    }

    private fun thenDataIsInsertedIntoDB() {
        verify(searchDao).insert(any())
    }

    private fun thenSearchDaoGetTvItemsIsCalled() {
        verify(searchDao).getTvItems(SOME_TEXT)
    }
}