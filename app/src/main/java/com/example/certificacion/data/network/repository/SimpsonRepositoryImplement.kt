package com.example.certificacion.data.network.repository

import com.example.certificacion.data.network.api.ApiService
import com.example.certificacion.data.network.response.SimpsonsResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SimpsonRepositoryImplement(private val apiService: ApiService) : SimpsonRepository {
    override suspend fun getAllSimpsons(): MutableList<SimpsonsResponseItem> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getAllSimspons()
            response
        }
    }



}