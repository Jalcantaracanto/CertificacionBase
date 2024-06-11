package com.example.certificacion.data.network.api

import com.example.certificacion.data.network.response.SimpsonsResponse
import retrofit2.http.GET

interface ApiService {

    @GET("quotes?count=15")
    suspend fun getAllSimspons(): SimpsonsResponse
}