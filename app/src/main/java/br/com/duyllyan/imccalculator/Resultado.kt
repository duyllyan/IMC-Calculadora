package br.com.duyllyan.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_resultado.*
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*
import kotlin.math.round

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        Locale.setDefault(Locale.US)
        //importar resultados
        val imcRecuperado = intent.getFloatExtra("imc", 0f)
        val statusRecuperado = intent.getParcelableExtra<IMC>("status")
        val df = DecimalFormat("#.##").apply { roundingMode = RoundingMode.CEILING }
        txvIMC.text = df.format(imcRecuperado)
        if (statusRecuperado != null) {
            txvStatus.setText(statusRecuperado.classificacao)
        }
        if (statusRecuperado != null) {
            imgStatus.setImageResource(statusRecuperado.imagem)
        }

        btnRepeat.setOnClickListener{
            startActivity(Intent(this@Resultado, MainActivity::class.java))
            finish()
        }
    }
}
