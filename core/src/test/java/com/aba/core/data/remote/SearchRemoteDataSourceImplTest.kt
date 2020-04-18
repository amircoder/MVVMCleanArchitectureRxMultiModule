package com.aba.core.data.remote

import com.SOME_SEARCH_RESPONSE_ITEMS
import com.SOME_TEXT
import com.aba.core.data.model.TVSearchResponse
import com.aba.core.data.net.service.TVMazeService
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
class SearchRemoteDataSourceImplTest {

    @Mock
    private lateinit var mockService: TVMazeService
    @InjectMocks
    private lateinit var subject: SearchRemoteDataSourceImpl

    private lateinit var result: TestObserver<List<TVSearchResponse>>
    private var someException = Exception(SOME_TEXT)

    @Test
    fun `givenResponseIsSuccessful whenOnSearch thenResultIsSuccessful`(){
        givenResponseIsSuccessful()
        whenOnSearch()
        thenResultIsSuccessful()
        thenMockServiceIsCalled()
    }

    @Test
    fun `givenResponseIsFailure whenOnSearch thenRequestNotCompleted`(){
        givenResponseIsFailure()
        whenOnSearch()
        thenRequestNotCompleted()
        thenMockServiceIsCalled()
    }



    /*
     * Given
     */
    private fun givenResponseIsSuccessful() {
        given(mockService.search(SOME_TEXT)).willReturn(
            Observable.just(SOME_SEARCH_RESPONSE_ITEMS)
        )
    }

    private fun givenResponseIsFailure() {
        given(mockService.search(SOME_TEXT)).willReturn(
            Observable.error(someException)
        )
    }

    /*
     * When
     */

    private fun whenOnSearch() {
        result = subject.search(SOME_TEXT).test()
    }

    /*
     * Then
     */

    private fun thenResultIsSuccessful() = with(result){
        assertComplete()
            .assertNoErrors()
            .assertValue(SOME_SEARCH_RESPONSE_ITEMS)
    }

    private fun thenRequestNotCompleted() = with(result){
        assertNotComplete()
            .assertError(someException)
            .assertErrorMessage(SOME_TEXT)
    }

    private fun thenMockServiceIsCalled() {
        verify(mockService).search(SOME_TEXT)
    }
}