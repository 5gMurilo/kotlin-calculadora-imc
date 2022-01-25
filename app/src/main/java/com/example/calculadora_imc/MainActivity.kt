package com.example.calculadora_imc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var peso:String? = ""
    private var altura:String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        inptAltura?.doAfterTextChanged {
            altura = it.toString()
        }
        inptPeso?.doAfterTextChanged {
            peso = it.toString()
        }

        btnCalcular.setOnClickListener{
            calcularIMC(peso, altura)
        }
    }

    private fun calcularIMC (p:String?, a: String?){
        if(rbMasc.isChecked ){
            if (p != null && a != null) {
                startActivity(Intent(this, ResultActivity::class.java).apply {
                    putExtra("sex", "masc")
                    putExtra("alt", a)
                    putExtra("peso",p)
                })
            }else{
                Toast.makeText(this, "Insira valores válidos nos campos", Toast.LENGTH_SHORT).show()
            }
        }else if(rbFem.isChecked){
            if (p != null && a != null) {
                startActivity(Intent(this, ResultActivity::class.java).apply {
                    putExtra("sex", "fem")
                    putExtra("alt", a.toFloat())
                    putExtra("peso",p.toFloat())
                })
            }else{
                Toast.makeText(this, "Insira valores válidos nos campos", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Selecione seu sexo", Toast.LENGTH_SHORT).show()
        }
    }
}