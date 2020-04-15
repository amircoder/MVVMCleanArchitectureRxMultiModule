package com.aba.core.data.remote

import com.aba.core.data.SOME_TEST
import com.aba.core.data.SearchDataHelper
import com.aba.core.data.model.SearchResponse
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.observers.TestObserver
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection


@RunWith(MockitoJUnitRunner::class)
class TVMazeServiceTest {

    private var mockWebServer = MockWebServer()
    private lateinit var subject: TVMazeService

    private lateinit var response: TestObserver<List<SearchResponse>>

    @Before
    fun setup(){
        subject = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
            .create(TVMazeService::class.java)
    }

    @After
    fun tearDown() = mockWebServer.shutdown()

    @Test
    fun `givenResponseIsSuccessful whenOnSearch then`(){
        givenResponseIsSuccessful()
        whenOnSearch()
        thenResponseIsSuccessful()
    }


    /*
     * Given
     */
    private fun givenResponseIsSuccessful() {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(
                    SearchDataHelper.getSearchBody()
                )
        )
    }

    /*
     * When
     */
    private fun whenOnSearch() {
        response = subject.search(SOME_TEST).test()
    }


    /*
     * Then
     */
    private fun thenResponseIsSuccessful() {
        response
            .assertNoTimeout()
            .assertNoErrors()
            .assertComplete()
    }
}