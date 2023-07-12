package com.example.viewmodelapp

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingNumber: Int): ViewModel() {
    private var counter: Int = 0

    // inicializando construtor na classe ViewModel
    // caso nao quisermos usar o factory remover parametro e contrutor dessa classe
    init {
        counter = startingNumber
    }

    fun getCounter(): Int {
        return this.counter
    }

    fun setCounter() {
        this.counter++
    }
}