package com.grupo.steps;

import io.cucumber.java.es.*;
import static org.junit.jupiter.api.Assertions.*;

import com.grupo.FactorialRecursivo;
import java.math.BigInteger;

public class AppSteps {

    private String entrada;
    private BigInteger resultado;
    private String mensajeError;

    @Dado("que ingreso el número {string}")
    public void que_ingreso_el_numero(String numero) {
        this.entrada = numero;
    }

    @Dado("no ingreso ningún valor")
    public void no_ingreso_ningun_valor() {
        this.entrada = "";
    }

    @Cuando("solicito calcular el factorial")
    public void solicito_calcular_el_factorial() {
        try {
            if (entrada == null || entrada.isEmpty()) {
                throw new IllegalArgumentException("Debe ingresar un número");
            }

            int n = Integer.parseInt(entrada);
            if (n < 0) {
                throw new IllegalArgumentException("El número debe ser positivo");
            }

            resultado = FactorialRecursivo.factorial(n);

        } catch (NumberFormatException e) {
            mensajeError = "Ingrese un número válido";
        } catch (IllegalArgumentException e) {
            mensajeError = e.getMessage();
        }
    }

    @Entonces("se muestra el mensaje de error {string}")
    public void se_muestra_el_mensaje_de_error(String mensajeEsperado) {
        assertEquals(mensajeEsperado, mensajeError,
            "❌ El mensaje de error no coincide con el esperado");
    }

    @Entonces("veo en pantalla {string}")
    public void veo_en_pantalla(String mensajeEsperado) {
        assertNotNull(resultado, "❌ No se generó resultado");
        assertTrue(mensajeEsperado.contains(resultado.toString()),
            "❌ El resultado mostrado no coincide con el esperado");
    }

    @Entonces("veo un mensaje de error que indica {string}")
    public void veo_un_mensaje_de_error_que_indica(String mensajeEsperado) {
        assertEquals(mensajeEsperado, mensajeError,
            "❌ El mensaje de error no coincide con el esperado");
    }

    @Entonces("la función utilizada debe ser recursiva")
    public void la_funcion_utilizada_debe_ser_recursiva() {
        BigInteger esperado = BigInteger.valueOf(24);
        BigInteger obtenido = FactorialRecursivo.factorial(4);
        assertEquals(esperado, obtenido,
            "❌ La función factorial no parece ser recursiva o retorna un valor incorrecto");
    }
}
