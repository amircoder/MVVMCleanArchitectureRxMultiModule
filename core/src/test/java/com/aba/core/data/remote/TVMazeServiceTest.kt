package com.aba.core.data.remote

import com.SOME_TEXT
import com.aba.core.data.SearchDataHelper
import com.aba.core.data.model.TVSearchResponse
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
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

    private lateinit var response: TestObserver<List<TVSearchResponse>>

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
        response = subject.search(SOME_TEXT).test()
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