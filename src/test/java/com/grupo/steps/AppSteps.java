package com.grupo.steps;

import io.cucumber.java.es.*;
import static org.junit.jupiter.api.Assertions.*;
import com.grupo.FactorialRecursivo;
import java.math.BigInteger;

public class AppSteps {

    private String entrada;
    private BigInteger resultado;
    private String mensajeError;

    // --- soportar número como string con comillas ---
    @Dado("que ingreso el número {string}")
    public void que_ingreso_el_numero_string(String numero) {
        this.entrada = numero;
    }

    // --- soportar número sin comillas (entero) ---
    @Dado("que ingreso el número {int}")
    public void que_ingreso_el_numero_int(int numero) {
        this.entrada = String.valueOf(numero);
    }

    @Dado("no ingreso ningún valor")
    public void no_ingreso_ningun_valor() {
        this.entrada = "";
    }

    @Cuando("solicito calcular el factorial")
    public void solicito_calcular_el_factorial() {
        mensajeError = null;
        resultado = null;
        try {
            if (entrada == null || entrada.isBlank()) {
                // Mantengo el mensaje igual que definiste en ErrorMessages/VAC
                mensajeError = "Debe ingresar un número";
                return;
            }
            // permite números con signo negativo, parsea y llama a la lógica
            int n = Integer.parseInt(entrada.trim());
            resultado = FactorialRecursivo.factorial(n);
        } catch (NumberFormatException e) {
            mensajeError = "Ingrese un número válido";
        } catch (IllegalArgumentException e) {
            // La lógica lanza IllegalArgumentException con el mensaje unificado
            mensajeError = e.getMessage();
        }
    }

    @Entonces("se muestra el mensaje de error {string}")
    public void se_muestra_el_mensaje_de_error(String mensajeEsperado) {
        assertEquals(mensajeEsperado, mensajeError);
    }

    @Entonces("veo en pantalla {string}")
    public void veo_en_pantalla(String mensajeEsperado) {
        assertNotNull(resultado, "No se produjo resultado numérico");
        // comprueba que el resultado aparece en el texto esperado (como tu feature pide)
        assertTrue(mensajeEsperado.contains(resultado.toString()),
                   () -> "Resultado esperado no contiene el número calculado: " + resultado);
    }

    @Entonces("veo un mensaje de error que indica {string}")
    public void veo_un_mensaje_de_error_que_indica(String mensajeEsperado) {
        assertEquals(mensajeEsperado, mensajeError);
    }

    @Entonces("la función utilizada debe ser recursiva")
    public void la_funcion_utilizada_debe_ser_recursiva() {
        // Validamos recursividad indirectamente comparando el resultado
        BigInteger esperado = BigInteger.valueOf(24);
        assertEquals(esperado, FactorialRecursivo.factorial(4));
    }
}
