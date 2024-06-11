package com.example.certificacion.data.network.retrofit

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://thesimpsonsquoteapi.glitch.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}