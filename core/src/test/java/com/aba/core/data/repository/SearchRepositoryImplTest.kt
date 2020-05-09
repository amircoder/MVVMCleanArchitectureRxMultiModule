package com.aba.core.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aba.core.*
import com.aba.core.data.local.datasource.SearchLocalDataSource
import com.aba.core.data.mapper.SearchMapper
import com.aba.core.data.remote.SearchRemoteDataSource
import com.aba.core.domain.model.SearchModel
import com.aba.core.network.ResultResponse
import com.aba.core.rx.SchedulerProvider
import com.aba.core.rx.TrampolineSchedulerProvider
import com.nhaarman.mockitokotlin2.*
import com.nhaarman.mockitokotlin2.any
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule
import java.lang.Exception

@RunWith(MockitoJUnitRunner::class)
class SearchRepositoryImplTest {

    private lateinit var result: TestObserver<ResultResponse<List<SearchModel>>>
    private val someException = Exception()

    @Mock
    private lateinit var mockRemoteDataSource: SearchRemoteDataSource
    @Mock
    private lateinit var mockLocalDataSource: SearchLocalDataSource
    private lateinit var subject: SearchRepositoryImpl

    private lateinit var schedulerProvider: SchedulerProvider


    @Rule
    lateinit var rule: InstantTaskExecutorRule
    @Rule
    lateinit var mockitoRule: MockitoRule

    @Before
    fun setup() {
        provideImmediateSchedulers()
        subject = SearchRepositoryImpl(
            mockRemoteDataSource,
            mockLocalDataSource
        )
    }


    @Test
    fun `givenLocalResponseSuccessful andGivenRemoteResponseSuccessful whenOnSearch thenResultIsSuccessful`() {
        givenLocalResponseSuccessful()
        givenRemoteResponseSuccessful()
        whenOnSearch()
        thenResultIsSuccessful()
        thenLocalDataSourceSaveData()
    }

    @Test
    fun `givenLocalResponseSuccessful andGivenRemoteResponseIsEmpty whenOnSearch thenResultIsLocal andNoDataIsSaved`() {
        givenLocalResponseSuccessful()
        givenRemoteResponseIsEmpty()
        whenOnSearch()
        thenResultIsLocal()
        andNoDataIsSaved()
    }

    @Test
    fun `givenLocalResponseIsEmpty andGivenRemoteResponseIsEmpty whenOnSearch thenEmptyResult andNoDataIsSaved`() {
        givenLocalResponseIsEmpty()
        givenRemoteResponseIsEmpty()
        whenOnSearch()
        thenEmptyResult()
        andNoDataIsSaved()
    }

    @Test
    fun `givenLocalResponseIsFailure andGivenRemoteResponseIsFailure whenOnSearch thenErrorResult andNoDataIsSaved`() {
        givenLocalResponseIsFailure()
        givenRemoteResponseIsFailure()
        whenOnSearch()
        thenErrorResult()
        andNoDataIsSaved()
    }

    @Test
    fun `givenLocalResponseIsEmpty andGivenRemoteResponseIsFailure whenOnSearch thenEmptySuccessResult andNoDataIsSaved`() {
        givenLocalResponseIsEmpty()
        givenRemoteResponseIsFailure()
        whenOnSearch()
        thenEmptySuccessResult()
        andNoDataIsSaved()
    }

    @Test
    fun `givenLocalResponseIsFailure andGivenRemoteResponseIsEmpty whenOnSearch thenEmptySuccessResult andNoDataIsSaved`() {
        givenLocalResponseIsFailure()
        givenRemoteResponseIsEmpty()
        whenOnSearch()
        thenEmptySuccessResult()
        andNoDataIsSaved()
    }


    /*
     * Given
     */
    private fun givenLocalResponseSuccessful() {
        given(mockLocalDataSource.search(SOME_TEXT)).willReturn(
            Observable.just(SOME_SEARCH_MODELS)
        )
    }

    private fun givenRemoteResponseSuccessful() {
        given(mockRemoteDataSource.search(SOME_TEXT)).willReturn(
            Observable.just(SOME_OTHER_SEARCH_MODELS)
        )
    }

    private fun givenRemoteResponseIsEmpty() {
        given(mockRemoteDataSource.search(SOME_TEXT)).willReturn(
            Observable.just(listOf())
        )
    }

    private fun givenLocalResponseIsEmpty() {
        given(mockLocalDataSource.search(SOME_TEXT)).willReturn(
            Observable.just(listOf())
        )
    }

    private fun givenRemoteResponseIsFailure() {
        given(mockRemoteDataSource.search(SOME_TEXT)).willReturn(
            Observable.error(someException)
        )
    }

    private fun givenLocalResponseIsFailure() {
        given(mockLocalDataSource.search(SOME_TEXT)).willReturn(
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
    private fun thenResultIsSuccessful() {
        result
            .assertNoErrors()
            .assertComplete()
            .assertValues(
                ResultResponse.Success(SOME_SEARCH_MODELS),
                ResultResponse.Success(SOME_OTHER_SEARCH_MODELS)
            )
    }

    private fun thenLocalDataSourceSaveData() {
        then(mockLocalDataSource).should().insert(any())
    }

    private fun thenResultIsLocal() {
        result
            .assertNoErrors()
            .assertComplete()
            .assertValues(ResultResponse.Success(SOME_SEARCH_MODELS), ResultResponse.Success(listOf()))
    }


    private fun andNoDataIsSaved() {
        verify(mockLocalDataSource, never()).insert(any())
    }

    private fun thenEmptyResult() {
        result
            .assertNoErrors()
            .assertComplete()
            .assertValues(ResultResponse.Success(listOf()), ResultResponse.Success(listOf()))
    }

    private fun thenErrorResult() {
        result
            .assertNotComplete()
            .assertValues()
    }

    private fun thenEmptySuccessResult() {
        result
            .assertNotComplete()
            .assertValues(ResultResponse.Success(listOf()))
    }



    /*
     * Helper
     */
    private fun provideImmediateSchedulers() {
        schedulerProvider = TrampolineSchedulerProvider()
    }
}