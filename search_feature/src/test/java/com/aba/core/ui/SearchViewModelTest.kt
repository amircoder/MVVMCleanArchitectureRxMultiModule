package com.aba.core.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aba.core.*
import com.aba.core.domain.data.SearchModel
import com.aba.core.domain.usecase.SearchUseCase
import com.aba.core.network.ResultResponse
import com.aba.core.network.error.ErrorEntity
import com.nhaarman.mockitokotlin2.anyOrNull
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {


    @get:Rule
    val rule = InstantTaskExecutorRule()


    @Mock
    lateinit var mockUseCase: SearchUseCase

    @InjectMocks
    lateinit var subject: SearchViewModel

    @Before
    fun setup() {
        given(mockUseCase.with(SOME_TEXT)).willReturn(
            SearchUseCase.SearchParams(SOME_TEXT)
        )
    }


    @Test
    fun `givenSearchResultSuccessful whenSearchFor thenResultIsSuccessful`() {
        givenSearchResultSuccessful()
        whenSearchFor()
        thenResultIsSuccessful()
        thenVerifyUseCaseSearchIsCalled()
    }



    @Test
    fun `givenSearchResultNetworkFailure whenSearchFor thenResultIsNetworkFailure`() {
        givenSearchResultNetworkFailure()
        whenSearchFor()
        thenResultIsNetworkFailure()
        thenVerifyUseCaseSearchIsCalled()
    }


    /*
    * Given
    */
    private fun givenSearchResultSuccessful() {
        given(mockUseCase.execute(anyOrNull())).willReturn(
            Observable.just(ResultResponse.Success(SOME_SEARCH_MODELS))
        )
    }

    private fun givenSearchResultNetworkFailure() {
        given(mockUseCase.execute(anyOrNull())).willReturn(
            Observable.just(ResultResponse.Failure(ErrorEntity.Network))
        )
    }


    /*
     * When
     */
    private fun whenSearchFor() {
        subject.searchFor(SOME_TEXT)
    }

    /*
     * Then
     */

    private fun thenResultIsSuccessful() = subject.searchResult.observeOnce {
        with((it as ResultResponse.Success<List<SearchModel>>).data) {
            assertThat(this).isEqualTo(SOME_SEARCH_MODELS)
        }
    }

    private fun thenResultIsNetworkFailure() = subject.searchResult.observeOnce {
        with((it as ResultResponse.Failure<List<SearchModel>>).error) {
            assertThat(this).isEqualTo(ErrorEntity.Network)
        }
    }

    private fun thenVerifyUseCaseSearchIsCalled() {
        verify(mockUseCase).execute(anyOrNull())
    }

}