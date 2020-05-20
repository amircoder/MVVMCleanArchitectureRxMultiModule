package com.aba.core.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aba.core.*
import com.aba.core.domain.model.SearchModel
import com.aba.core.domain.usecase.SearchUseCase
import com.aba.core.network.ResultResponse
import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import io.reactivex.processors.PublishProcessor
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

    private lateinit var responseProxy: PublishProcessor<ResultResponse<List<SearchModel>>>
    @Mock
    private lateinit var mockUseCase: SearchUseCase
    @InjectMocks
    private lateinit var subject: SearchViewModel



    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    var timeoutRule: RxImmediateSchedulerRule = RxImmediateSchedulerRule()

    @Before
    fun setup(){
        responseProxy = PublishProcessor.create()
        given(mockUseCase.execute(any())).willReturn(
            responseProxy.toObservable()
        )
    }

//    @After
//    fun tearDown(){
//        proxyDisposable.clear()
//    }


    @Test
    fun `givenSuccessfulResult whenOnSearch thenResultIsAvailable`(){
        givenSuccessfulResult()
        whenOnSearch()
        thenResultIsAvailable()
        thenUseCaseExecuteCalled()
    }

    @Test
    fun `givenFailureResult whenOnSearch thenResultIsFailure`(){
        givenFailureResult()
        whenOnSearch()
        thenResultIsFailure()
        thenUseCaseExecuteCalled()
    }



    /*
     * Given
     */
    private fun givenSuccessfulResult() {
        given(mockUseCase.execute(any())).willReturn(Observable.just(ResultResponse.Success(
            SOME_SEARCH_MODELS) as ResultResponse<List<SearchModel>>))
//        responseProxy.apply {
//            onNext(
//                SOME_SUCCESS_RESULT
//            )
//        }
    }

    private fun givenFailureResult() {
        given(mockUseCase.execute(any())).willReturn(Observable.just(ResultResponse.Failure(SOME_ERROR_ENTITY)))
//        responseProxy.onNext(
//            SOME_FAILURE_RESULT
//        )
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

//        subject.searchLiveData.test().assertValueHistory(
//            SOME_LOADING_RESULT,
//            SOME_SUCCESS_RESULT
//        )

        subject.searchLiveData.test().valueHistory().forEach {
            println(it.toString())
        }
    }

    private fun thenUseCaseExecuteCalled() {
        verify(mockUseCase).execute(any())
    }

    private fun thenResultIsFailure() {
//        subject.searchLiveData.observeOnce {result ->
//            with((result as ResultResponse.Failure).error){
//                assertThat(this).isEqualTo(SOME_ERROR_ENTITY)
//            }
//        }

//        subject.searchLiveData.test().awaitNextValue()
//        subject.searchLiveData.test().assertValue(SOME_LOADING_RESULT)
//        subject.searchLiveData.test().awaitNextValue()
//        subject.searchLiveData.test().assertValue(SOME_FAILURE_RESULT)

//        subject.searchLiveData.test().assertValueHistory(
//            SOME_LOADING_RESULT,
//            SOME_FAILURE_RESULT
//        )

        subject.searchLiveData.test().valueHistory().forEach {
            println(it.toString())
        }
    }

}

