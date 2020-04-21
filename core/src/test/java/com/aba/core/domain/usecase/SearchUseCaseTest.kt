package com.aba.core.domain.usecase

import com.aba.core.SOME_SEARCH_MODELS
import com.aba.core.SOME_TEXT
import com.aba.core.domain.data.SearchModel
import com.aba.core.domain.repository.SearchRepository
import com.aba.core.domain.usecase.SearchUseCase.SearchParams
import com.aba.core.network.ResultResponse
import com.aba.core.network.error.ErrorContainer
import com.aba.core.network.error.ErrorEntity
import com.aba.core.rx.SchedulerProvider
import com.aba.core.rx.TestSchedulerProvider
import com.aba.core.rx.TrampolineSchedulerProvider
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SearchUseCaseTest {

    private lateinit var param: SearchParams
    private lateinit var result: TestObserver<ResultResponse<List<SearchModel>>>
    private val searchParam = SearchParams(SOME_TEXT)
    private val stubException = Exception()

    private lateinit var schedulerProvider: SchedulerProvider
    @Mock
    private lateinit var searchRepository: SearchRepository
    @Mock
    private lateinit var errorContainer: ErrorContainer

    private lateinit var subject: SearchUseCase

    @Before
    fun setup() {
        provideImmediateSchedulers()
        initMocks(this)
        subject = SearchUseCase(
            searchRepository,
            schedulerProvider,
            errorContainer
        )
    }

    @Test
    fun `whenOnSearch givenSuccessfulResponse thenResultIsSuccessful`() {
        givenSuccessfulResponse()
        whenOnSearch()
        thenResultIsSuccessful()
        thenRepositoryIsCalled()
    }

    @Test
    fun `whenOnSearch givenFailureResponse thenResultIsFailure`() {
        givenErrorContainer()
        givenFailureResponse()
        whenOnSearch()
        thenResultIsFailure()
        thenRepositoryIsCalled()
    }

    @Test
    fun `whenOnWith givenQueryString thenParamIsCreated`(){
        whenOnWith()
        thenParamIsCreated()
    }


    /*
     * Given
     */
    private fun givenSuccessfulResponse() {
        given(searchRepository.search(SOME_TEXT)).willReturn(
            Observable.just(ResultResponse.Success(SOME_SEARCH_MODELS))
        )
    }

    private fun givenFailureResponse() {
        given(searchRepository.search(SOME_TEXT)).willReturn(
            Observable.error(stubException)
        )
    }

    private fun givenErrorContainer() {
        given(errorContainer.getError(any())).willReturn(ErrorEntity.Network)
    }


    /*
     * When
     */
    private fun whenOnSearch() {
        result = subject.execute(searchParam).test()
    }

    private fun whenOnWith() {
        param = subject.with(SOME_TEXT)
    }
    /*
     * Then
     */
    private fun thenResultIsSuccessful() = with(result) {
        assertComplete()
            .assertNoErrors()
            .assertValue(ResultResponse.Success(SOME_SEARCH_MODELS))
    }

    private fun thenRepositoryIsCalled() {
        verify(searchRepository).search(SOME_TEXT)
    }

    private fun thenResultIsFailure() = with(result) {
            assertComplete()
            .assertValue(ResultResponse.Failure(ErrorEntity.Network))
    }

    private fun thenParamIsCreated() {
        assertThat(param).isEqualTo(SearchParams(SOME_TEXT))
    }

    /*
     * Helper
     */
    private fun provideImmediateSchedulers() {
        schedulerProvider = TrampolineSchedulerProvider()
    }

    private fun provideTestSchedulers() {
        schedulerProvider = TestSchedulerProvider()
    }

}