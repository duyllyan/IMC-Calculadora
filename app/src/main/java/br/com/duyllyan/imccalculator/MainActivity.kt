package br.com.duyllyan.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val imcViewModel: IMCViewModel by lazy {
        ViewModelProvider(this).get(IMCViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener{

            val peso = etnPeso.text.toString().trim()
            val altura = etnAltura.text.toString().trim()

            //verificar campos
            if (peso.isEmpty() || peso == ".") {
                etnPeso.error = getString(R.string.insira_peso)
            }else if (altura.isEmpty() || altura == ".") {
                etnAltura.error = getString(R.string.insira_altura)
            }else if (peso.toFloat() <= 36.6f || peso.toFloat() > 136.1f) {
                etnPeso.error = getString(R.string.insira_peso_kg)
            }else if (altura.toFloat() <= 140f || altura.toFloat() > 220f) {
                etnAltura.error = getString(R.string.insira_altura_cm)
            }else {
                //calculo do IMC
                val imc = peso.toFloat()/((altura.toFloat()/100)*(altura.toFloat()/100))
                val intent = Intent(this, Resultado::class.java)
                //abrir a tela de resultado
                intent.apply {
                    putExtra("imc", imc)
                    putExtra("status", imcViewModel.checkIMC(imc))
                }
                startActivity(intent)
                finish()
                //limpar os campos
                etnPeso.text.clear()
                etnAltura.text.clear()
            }
        }
    }
}

