package com.example.calculadora_imc

class Imc(
    var peso: Float?,
    var altura: Float?,
    var sexo: String?
) {

    var conditionTxt: String = ""
        private set

    var ideal: String = ""
        private set


    //extension functions
    private fun calculaPeso(a: Float?, i: Float?) = i?.times((a?.times(a)!!))

    private fun calcImc(a: Float?, p: Float?) = p?.div((a?.times(a)!!))

    private fun pesoIdeal(imc: Float): String {
        // o imc passado como parâmetro é o imc recomendado para determinado sexo
        val kgIdeal = calculaPeso(altura, imc)
        return "O seu peso ideal é em média ${String.format("%.2f", kgIdeal)}KGs"
    }

    fun calcularImc(): Float? {
        return calcImc(altura, peso)
    }

    fun showImc() {

        val imc:Float? = calcularImc()

        if (sexo == "masc" && sexo != null) {
            when {
                imc!! < 20.7f -> {
                    conditionTxt = "você está abaixo do peso"
                    ideal = pesoIdeal(26f)
                }
                imc!! in 20.7f..26.4f -> {
                    conditionTxt = "Parabéns, seu peso é ideal!"
                }
                imc!! in 26.5f..27.8f -> {
                    conditionTxt = "Seu peso está marginalmente acima do ideal!"
                    ideal = pesoIdeal(26f)
                }
                imc!! in 27.8f..31.1f -> {
                    conditionTxt = "Você está acima do peso ideal!"
                    ideal = pesoIdeal(26f)
                }
                else -> {
                    conditionTxt = "Você está obeso!"
                    ideal = pesoIdeal(26f)
                }
            }
        } else {
            when {
                imc!! < 19.1f -> {
                    conditionTxt = "você está abaixo do peso"
                    ideal = pesoIdeal(26f)
                }
                imc!! in 19.1f..25.8f -> {
                    conditionTxt = "Parabéns, seu peso é ideal!"
                }
                imc!! in 25.9f..27.3f -> {
                    conditionTxt = "Seu peso está marginalmente acima do ideal!"
                    ideal = pesoIdeal(26f)
                }
                imc!! in 27.4f..32.3f -> {
                    conditionTxt = "Você está acima do peso ideal!"
                    ideal = pesoIdeal(26f)
                }
                else -> {
                    conditionTxt = "Você está obesa!"
                    ideal = pesoIdeal(26f)
                }
            }
        }

    }

}