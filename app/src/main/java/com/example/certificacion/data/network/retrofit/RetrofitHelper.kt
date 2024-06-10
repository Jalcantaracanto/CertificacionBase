package com.example.certificacion.data.network.retrofit

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(context: Context): Retrofit {

        return Retrofit.Builder()
            .baseUrl("HTTPS ALGO")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}