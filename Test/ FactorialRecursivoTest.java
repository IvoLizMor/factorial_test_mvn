package com.example;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class FactorialRecursivoTest {

    // 🔹 Tests para multiplicar
    @Test
    void testMultiplicarCasoBase() {
        assertEquals(7, FactorialRecursivo.multiplicar(7, 1));
    }

    @Test
    void testMultiplicarPorCero() {
        assertEquals(0, FactorialRecursivo.multiplicar(7, 0));
    }

    @Test
    void testMultiplicarNumeroNormal() {
        assertEquals(12, FactorialRecursivo.multiplicar(3, 4));
    }

    @Test
    void testMultiplicarConNegativo() {
        assertEquals(-12, FactorialRecursivo.multiplicar(-3, 4));
        assertEquals(12, FactorialRecursivo.multiplicar(-3, -4));
    }

    // 🔹 Tests paramétricos para factorial con valores correctos
    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "5, 120",
        "7, 5040",
        "10, 3628800"
    })
    void testFactorialValoresValidos(int n, long esperado) {
        assertEquals(esperado, FactorialRecursivo.factorial(n));
    }

    // 🔹 Test explícito de caso base factorial(1)
    @Test
    void testFactorialUno() {
        assertEquals(1, FactorialRecursivo.factorial(1));
    }

    // 🔹 Tests para factorial con valores negativos (espera excepción)
    @ParameterizedTest
    @ValueSource(ints = {-1, -3, -10})
    void testFactorialNegativos(int n) {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialRecursivo.factorial(n);
        });
    }

    // 🔹 Verificar mensaje de excepción en negativos
    @Test
    void testFactorialNegativoMensaje() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            FactorialRecursivo.factorial(-5);
        });
        assertEquals("n debe ser >= 0", ex.getMessage());
    }

    // 🔹 Test para factorial de un número grande pero dentro de los límites de long
    @Test
    void testFactorialGrande() {
        assertEquals(2432902008176640000L, FactorialRecursivo.factorial(20));
    }

    // 🔹 Test de límite: factorial más allá de 20 debe lanzar excepción (overflow)
    @Test
    void testFactorialOverflow() {
        assertThrows(ArithmeticException.class, () -> {
            FactorialRecursivo.factorial(21);
        });
    }

    // 🔹 Test de performance: verificar que factorial no tarde demasiado
    @Test
    void testPerformanceFactorial() {
        assertTimeout(Duration.ofMillis(100), () -> {
            FactorialRecursivo.factorial(15);
        });
    }

    // 🔹 Test de consistencia contra implementación iterativa
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void testFactorialConsistencia(int n) {
        long esperado = factorialIterativo(n);
        assertEquals(esperado, FactorialRecursivo.factorial(n));
    }

    // Implementación auxiliar para consistencia
    private long factorialIterativo(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }
}

  
