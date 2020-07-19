package br.com.duyllyan.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener{

            val peso = etnPeso.text.toString().trim()
            val altura = etnAltura.text.toString().trim()

            //verificar campos
            if (peso.isEmpty() || peso == ".") {
                etnPeso.error = "Insira o peso"
            }else if (altura.isEmpty() || altura == ".") {
                etnAltura.error = "Insira a altura"
            }else if (peso.toFloat() <= 0.0f || peso.toFloat() > 300f) {
                etnPeso.error = "Insira um valor válido para o peso em quilogramas(kg)"
            }else if (altura.toFloat() <= 30f || altura.toFloat() > 400f) {
                etnAltura.error = "Insira um valor válido para a altura em centímetros(cm)"
            }else {
                //calculo do IMC
                var imc = peso.toFloat() / ((altura.toFloat()/100)*(altura.toFloat()/100))
                imc = round(imc)
                //mostrar o status com base no calculo
                fun checarIMC(i: Float): Array<String>{
                    when (i){
                        in 0.0..18.49 -> return arrayOf("Abaixo do peso",R.drawable.ic_alert.toString())
                        in 18.5..24.99 -> return arrayOf("Peso normal",R.drawable.ic_ok.toString())
                        in 25.0..29.99 -> return arrayOf("Acima do peso",R.drawable.ic_alert.toString())
                        in 30.0..34.99 -> return arrayOf("Obesidade Grau I",R.drawable.ic_number1.toString())
                        in 35.0..39.99 -> return arrayOf("Obesidade Grau II (Severa)",R.drawable.ic_number2.toString())
                        else -> return arrayOf("Obesidade Grau III (Mórbida)",R.drawable.ic_number2.toString())
                    }
                }

                //abrir a tela de resultado
                startActivity(Intent(this@MainActivity, Resultado::class.java).apply {
                   //exportar resultados
                    putExtra("imc", imc.toString())
                    putExtra("status", checarIMC(imc))
                })
                finish()
                //limpar os campos
                etnPeso.text.clear()
                etnAltura.text.clear()
            }
        }
    }
}

