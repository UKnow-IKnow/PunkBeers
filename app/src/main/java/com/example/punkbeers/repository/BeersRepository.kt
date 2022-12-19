package com.example.punkbeers.repository

import com.example.punkbeers.api.PunkClient

object BeersRepository {
    val api = PunkClient().api

    suspend fun getDiscoverBeers() = api.getBeers()

}