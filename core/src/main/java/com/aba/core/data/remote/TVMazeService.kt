package com.aba.core.data.remote

import com.aba.core.data.model.TVSearchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface TVMazeService {

    @GET("search/shows")
    fun search(@Query("q") query: String): Observable<List<TVSearchResponse>>

}