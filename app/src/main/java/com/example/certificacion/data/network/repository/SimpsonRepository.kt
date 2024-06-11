package com.example.certificacion.data.network.repository

import com.example.certificacion.data.network.response.SimpsonsResponseItem

interface SimpsonRepository {

    suspend fun getAllSimpsons(): MutableList<SimpsonsResponseItem>
}