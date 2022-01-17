package com.example.calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.w("Lifecycle", "entrei no Create - a tela está sendo criada")
    }

    override fun onStart() {
        super.onStart()
        Log.w("Lifecycle", "entrei no Start - a tela está visível")
    }

    override fun onResume() {
        super.onResume()
        Log.w("Lifecycle", "entrei no Resume - agora você pode interagir com a tela")
    }

    override fun onPause() {
        super.onPause()
        Log.w("Lifecycle", "entrei no Pause - a tela perdeu o foco, você não consegue interagir")
    }

    override fun onStop() {
        super.onStop()
        Log.w("Lifecycle", "entrei no Stop - a tela não está mais visível, mas ainda existe")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("Lifecycle", "entrei no Destroy - a tela foi destruída")
    }
}