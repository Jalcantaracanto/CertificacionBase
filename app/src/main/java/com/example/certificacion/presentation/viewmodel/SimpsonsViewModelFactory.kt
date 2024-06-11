package com.example.certificacion.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.certificacion.domain.SimpsonsUseCase

class SimpsonsViewModelFactory(private val simpsonsUseCase: SimpsonsUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SimpsonsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SimpsonsViewModel(simpsonsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}