package com.example.certificacion.domain

import com.example.certificacion.data.network.repository.SimpsonRepositoryImplement

class SimpsonsUseCase(private val simpsonRepositoryImplement: SimpsonRepositoryImplement) {

    suspend fun getAllSimpsons() = simpsonRepositoryImplement.getAllSimpsons()

}