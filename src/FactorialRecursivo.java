package com.example;

import java.util.HashMap;
import java.util.Map;

public class FactorialRecursivo {

    // 🔹 Cache para memorización de factoriales ya calculados
    private static Map<Integer, Long> cache = new HashMap<>();

    // Multiplicación recursiva usando long para evitar desbordamiento
    public static long multiplicar(long x, long p) {
        if (p == 0) return 0;
        if (p > 0) return x + multiplicar(x, p - 1);
        return -multiplicar(x, -p); // Manejo de negativos
    }

    // Factorial recursivo con memorización
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }

        // Casos base
        if (n == 0 || n == 1) return 1;

        // Verificar si ya está guardado en cache
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // Calcular de manera recursiva
        long resultado = n * factorial(n - 1);

        // Guardar en cache para futuras llamadas
        cache.put(n, resultado);

        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Factorial de 20: " + factorial(20)); // 2432902008176640000
        System.out.println("Multiplicación de -3 * -4: " + multiplicar(-3, -4)); // 12

        // Ejemplo de memorización: la segunda llamada es mucho más rápida
        System.out.println("Factorial de 20 (nuevamente, desde cache): " + factorial(20));
    }
}
