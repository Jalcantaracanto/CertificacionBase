package com.example.certificacion.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.certificacion.data.network.response.SimpsonsResponseItem
import com.example.certificacion.domain.SimpsonsUseCase
import kotlinx.coroutines.launch

class SimpsonsViewModel(private val simpsonsUseCase: SimpsonsUseCase): ViewModel() {


    private val _simpsonsList = MutableLiveData<MutableList<SimpsonsResponseItem>>()
    val simpsonsList: MutableLiveData<MutableList<SimpsonsResponseItem>> get() = _simpsonsList

    private val _selectedSimpson = MutableLiveData<SimpsonsResponseItem>()
    val selectedSimpson: MutableLiveData<SimpsonsResponseItem> get() = _selectedSimpson


    init{
        getAllSimpsons()
    }

    fun getAllSimpsons(){
        viewModelScope.launch {
            val result = simpsonsUseCase.getAllSimpsons()
            _simpsonsList.value = result
        }
    }

    fun selectSimpson(simpson: SimpsonsResponseItem){
        _selectedSimpson.value = simpson
    }

}