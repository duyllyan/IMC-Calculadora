package br.com.duyllyan.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        //importar resultados
        val imcRecuperado = intent.getStringExtra("imc")
        val statusRecuperado = intent.getStringArrayExtra("status")
        txvIMC.text = imcRecuperado
        txvStatus.text = statusRecuperado[0].toString()
        imgStatus.setImageResource(statusRecuperado[1].toInt())

        btnRepeat.setOnClickListener{
            startActivity(Intent(this@Resultado, MainActivity::class.java))
            finish()
        }
    }
}
