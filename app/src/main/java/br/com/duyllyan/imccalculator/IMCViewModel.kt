package br.com.duyllyan.imccalculator

import androidx.lifecycle.ViewModel

class IMCViewModel : ViewModel() {
    private val listaDeClassificacoes = listOf<IMC>(
        IMC(R.string.imc_baixo, R.drawable.ic_alert),
        IMC(R.string.imc_nomral, R.drawable.ic_ok),
        IMC(R.string.imc_alto, R.drawable.ic_alert),
        IMC(R.string.imc_obesidade_I, R.drawable.ic_number1),
        IMC(R.string.imc_obesidade_II, R.drawable.ic_number2),
        IMC(R.string.imc_obesidade_III, R.drawable.ic_number3)
    )

    fun checkIMC(valorIMC: Float) : IMC {
        return when (valorIMC) {
            in 0.0..18.49 -> listaDeClassificacoes[0]
            in 18.5..24.99 -> listaDeClassificacoes[1]
            in 25.0..29.99 -> listaDeClassificacoes[2]
            in 30.0..34.99 -> listaDeClassificacoes[3]
            in 35.0..39.99 -> listaDeClassificacoes[4]
            else -> listaDeClassificacoes[5]
        }
    }
}