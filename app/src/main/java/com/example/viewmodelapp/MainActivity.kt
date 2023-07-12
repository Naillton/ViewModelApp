package com.example.viewmodelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelapp.databinding.ActivityMainBinding

/**
 * O ViewModel trabalha com dados no nosso app guardando os dados em uma classe para podermos utilizar no app.
 * O ViewModelFactory ajuda o ViewModel a trabalhar com parametros na classe, onde poderiamos passar valores iniciais
 * para a classe ViewModel nos permitindo trabalhar com os valores pre-definidos
 */

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var factory: MainActivityModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // usando o ViewModelFactory para conseguirmos passar parametros no nosso construtor ViewModel
        factory = MainActivityModelFactory(120)

        // usando o ViewModelProvider passando o contexto atual como dono e acessando a classe Model
        // OBS: O app nao funciona se voce nao prover o viewModel, mesmo conseguindo acessar os metodos
        // viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        // para usarmos o ViewModelFactory teriamos que passar como segundo parametro do provider
        // o factory que definimos acima, dessa forma conseguiriamos iniciar o valor como 120
        viewModel = ViewModelProvider(this, factory)[MainActivityViewModel::class.java]

        binding.textView.text = viewModel.getCounter().toString()

        binding.button.setOnClickListener{
            viewModel.setCounter()
            binding.textView.text = viewModel.getCounter().toString()
        }
    }
}