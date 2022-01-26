package com.example.calculadora_imc

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(RobolectricTestRunner::class)
class ImcTest {
    //mock dos dados - preparação do teste
    private val imcHelper = ImcHelper(
        listOf(
            Imc(
                93f,
                1.77f,
                "masc"
            ),
            Imc(
                104f,
                1.6f,
                "fem"
            )
        )
    )

    @Test
    fun `Quando chamar o metodo getImc com dois imcs deve retornar uma lista com 2 imcs`() {
        //validação
        val list = imcHelper.getImcList()
        Assert.assertEquals(2, list.size)

    }

    @Test
    fun `Calcular o imc`() {
        val list = imcHelper.getImc()
        Assert.assertEquals(40.624996f, list[1])
    }

}