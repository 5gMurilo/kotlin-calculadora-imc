package com.example.calculadora_imc

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        showIMC()

    }

    private fun showIMC(){
        val imc: Float? = intent.extras?.getFloat("imc")
        val altura: Float? = intent.extras?.getString("alt")?.toFloat()
        val sexo: String? = intent.extras?.getString("sex")

        IMC.text = String.format("%.2f", imc)

        if(sexo == "masc"){
            if (imc != null) {
                when {
                    imc < 20.7f -> {
                        conditionTxt.setTextColor(Color.parseColor("#6A4C93"))
                        conditionTxt.text = getString(R.string.abaixoDoPeso)
                        ideal.text = calcPesoIdeal(altura, 24f,::calculaPeso)
                    }
                    imc in 20.7f..26.4f -> {
                        conditionTxt.setTextColor(Color.parseColor("#8AC926"))
                        conditionTxt.text = getString(R.string.pesoIdeal)
                    }
                    imc in 26.5f.. 27.8f -> {
                        conditionTxt.setTextColor(Color.parseColor("#FFCA3A"))
                        conditionTxt.text = getString(R.string.poucoAcimaDoPeso)
                        ideal.text = calcPesoIdeal(altura, 24f,::calculaPeso)
                    }
                    imc in 27.8f.. 31.1f -> {
                        conditionTxt.setTextColor(Color.parseColor("#FA8734"))
                        conditionTxt.text = getString(R.string.acimaDoPeso)
                        ideal.text = calcPesoIdeal(altura, 24f,::calculaPeso)
                    }
                    else -> {
                        conditionTxt.setTextColor(Color.parseColor("#F4442E"))
                        conditionTxt.text = getString(R.string.obeso)
                        ideal.text = calcPesoIdeal(altura, 24f,::calculaPeso)
                    }
                }
            }
        }else{
            if (imc != null) {
                when {
                    imc < 19.1f -> {
                        conditionTxt.setTextColor(Color.parseColor("#6A4C93"))
                        conditionTxt.text = getString(R.string.abaixoDoPeso)
                        ideal.text = calcPesoIdeal(altura, 22.5f,::calculaPeso)
                    }
                    imc in 19.1f..25.8f -> {
                        conditionTxt.setTextColor(Color.parseColor("#8AC926"))
                        conditionTxt.text = getString(R.string.pesoIdeal)
                    }
                    imc in 25.9f.. 27.3f -> {
                        conditionTxt.setTextColor(Color.parseColor("#FFCA3A"))
                        conditionTxt.text = getString(R.string.poucoAcimaDoPeso)
                        ideal.text = calcPesoIdeal(altura, 22.5f,::calculaPeso)
                    }
                    imc in 27.4f .. 32.3f -> {

                        conditionTxt.setTextColor(Color.parseColor("#FA8734"))
                        conditionTxt.text = getString(R.string.acimaDoPeso)
                        ideal.text = calcPesoIdeal(altura, 22.5f,::calculaPeso)

                    }
                    else -> {
                        conditionTxt.setTextColor(Color.parseColor("#F4442E"))
                        conditionTxt.text = getString(R.string.obeso)
                        ideal.text = calcPesoIdeal(altura, 22.5f,::calculaPeso)
                    }
                }

            }
        }

    }

    private fun calculaPeso(a:Float?, i:Float?) = i?.times((a?.times(a)!!))

    private fun calcPesoIdeal(
        altura:Float?,
        imc:Float?,
        formula: (Float?, Float?) -> Float?
    ):String{
        var kgIdeal = formula(altura, imc)
        return "O seu peso ideal é ${String.format("%.2f", kgIdeal)}kg"
    }
}