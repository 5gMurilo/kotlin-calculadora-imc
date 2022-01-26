package com.example.calculadora_imc

class ImcHelper(private val imcs:List<Imc>) {

    fun getImc(): MutableList<Float> {
        var lista = mutableListOf<Float>()
        for(valor in imcs){
            var calc = valor.peso?.div((valor.altura?.times(valor.altura!!)!!))
            if (calc != null) {
                lista.add(calc)
            }
        }
        return lista
    }

    fun getImcList(): List<Imc>{
        return imcs
    }


}