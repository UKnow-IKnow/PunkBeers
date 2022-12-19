package com.example.punkbeers.api

import com.example.punkbeers.api.models.Beer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PunkAPI {

    @GET("beers")
    suspend fun getBeers(
        @Query("ids") ids: Int? = null
    ): Response<List<Beer>>

}