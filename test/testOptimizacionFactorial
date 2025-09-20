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
        "5, 120",
        "7, 5040",
        "10, 3628800"
    })
    void testFactorialValoresValidos(int n, long esperado) {
        assertEquals(esperado, FactorialRecursivo.factorial(n));
    }

    // 🔹 Tests para factorial con valores negativos (espera excepción)
    @ParameterizedTest
    @ValueSource(ints = {-1, -3, -10})
    void testFactorialNegativos(int n) {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialRecursivo.factorial(n);
        });
    }

    // 🔹 Test para factorial de un número grande pero dentro de los límites de long
    @Test
    void testFactorialGrande() {
        assertEquals(2432902008176640000L, FactorialRecursivo.factorial(20));
    }

    // 🔹 Test de performance: verificar que factorial no tarde demasiado
    @Test
    void testPerformanceFactorial() {
        assertTimeout(Duration.ofMillis(100), () -> {
            FactorialRecursivo.factorial(15);
        });
    }

    // 🔹 Test específico para la HU: Optimización de función factorial básica
    @Test
    void testFactorialMemoizationPerformance() {
        // Primera llamada: puede tardar un poco más porque llena la cache
        assertTimeout(Duration.ofMillis(500), () -> {
            FactorialRecursivo.factorial(30);
        });

        // Segunda llamada: debe ser mucho más rápida gracias a la memoización
        assertTimeout(Duration.ofMillis(50), () -> {
            FactorialRecursivo.factorial(30);
        });
    }
}
