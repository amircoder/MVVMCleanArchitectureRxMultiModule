package com.aba.core.ui

import com.aba.core.SOME_SEARCH_MODELS
import com.aba.core.SOME_TEXT
import com.aba.core.any
import com.aba.core.domain.usecase.SearchUseCase
import com.aba.core.network.ResultResponse
import com.aba.core.observeOnce
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Observable
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {


    @Mock
    private lateinit var mockUseCase: SearchUseCase
    @InjectMocks
    private lateinit var subject: SearchViewModel


    @Test
    fun `givenSuccessfulResult whenOnSearch thenResultIsAvailable`(){
        givenSuccessfulResult()
        whenOnSearch()
        thenResultIsAvailable()
    }




    /*
     * Given
     */
    private fun givenSuccessfulResult() {
        given(mockUseCase.execute(any())).willReturn(Observable.just(ResultResponse.Success(
            SOME_SEARCH_MODELS)))
    }

    /*
     * When
     */
    private fun whenOnSearch() {
        subject.search(SOME_TEXT)
    }

    /*
     * Then
     */
    private fun thenResultIsAvailable() {
        subject.searchLiveData.observeOnce { result ->
            with((result as ResultResponse.Success).data){
                assertThat(this).isEqualTo(SOME_SEARCH_MODELS)
            }
        }
    }
}