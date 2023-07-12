package com.example.viewmodelapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityModelFactory(private val startingNumber: Int): ViewModelProvider.Factory {
    // sobrescrevendo funcao de criacao onde nos iniciamos no nosso ViewModel um valor passado pelo parametro
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(startingNumber) as T
        }
        throw IllegalAccessException("Uknow view model class")
    }
}