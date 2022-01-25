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

        calls()
    }

    private fun calls(){
        val imc = Imc(
            peso = intent.extras?.get("peso").toString().toFloat(),
            altura = intent.extras?.get("alt").toString().toFloat(),
            sexo = intent.extras?.getString("sex")
        )

        imc.showImc()

        conditionTxt.text = imc.conditionTxt
        ideal.text = imc.ideal

        val sex = imc.sexo
        val resultImcCalc = imc.calcularImc()

        if(sex == "masc"){
            when{
                resultImcCalc!! < 20.7f -> {
                    conditionTxt.setTextColor(Color.parseColor("#6A4C93"))
                }
                resultImcCalc in 20.8f.. 26.4f -> {
                    conditionTxt.setTextColor(Color.parseColor("#8AC926"))
                }
                resultImcCalc in 26.5f..27.8f -> {
                    conditionTxt.setTextColor(Color.parseColor("#FFCA3A"))
                }
                resultImcCalc in 27.8f..31.1f -> {
                    conditionTxt.setTextColor(Color.parseColor("#FA8734"))
                }
                else -> {
                    conditionTxt.setTextColor(Color.parseColor("#F4442E"))
                }
            }
        }else{
            when {
                resultImcCalc!! < 19.1f -> {
                    conditionTxt.setTextColor(Color.parseColor("#6A4C93"))
                }
                resultImcCalc in 19.1f..25.8f -> {
                    conditionTxt.setTextColor(Color.parseColor("#8AC926"))
                }
                resultImcCalc in 25.9f..27.3f -> {
                    conditionTxt.setTextColor(Color.parseColor("#FFCA3A"))
                }
                resultImcCalc in 27.4f..32.3f -> {
                    conditionTxt.setTextColor(Color.parseColor("#FA8734"))
                }
                else -> {
                    conditionTxt.setTextColor(Color.parseColor("#F4442E"))
                }
            }
        }
    }

}