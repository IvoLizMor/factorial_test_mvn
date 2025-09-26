package com.example;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FactorialRecursivo {

    // Multiplicación recursiva usando long (se conserva para los tests existentes)
    public static long multiplicar(long x, long p) {
        if (p == 0) return 0;
        if (p > 0) return x + multiplicar(x, p - 1);
        return -multiplicar(x, -p); // Manejo de negativos
    }

    // Cache para memorización de factoriales ya calculados
    private static Map<Integer, BigInteger> cache = new HashMap<>();

    // Factorial recursivo con memorización y BigInteger (soporta hasta 100! o más)
    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n debe ser >= 0");
        }

        // Casos base
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        // Revisar si ya está en cache
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // Calcular recursivamente y guardar en cache
        BigInteger resultado = BigInteger.valueOf(n).multiply(factorial(n - 1));
        cache.put(n, resultado);
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Factorial de 20: " + factorial(20));
        System.out.println("Factorial de 50: " + factorial(50));
        System.out.println("Factorial de 100: " + factorial(100));
        System.out.println("Multiplicación de -3 * -4: " + multiplicar(-3, -4));
    }
}
