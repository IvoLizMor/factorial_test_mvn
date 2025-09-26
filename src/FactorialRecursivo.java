package com.example;
 
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
 
public class FactorialRecursivo {
 
    // Cache para memorización de factoriales ya calculados
    private static Map<Integer, BigInteger> cache = new HashMap<>();
 
    // Factorial recursivo con memorización y BigInteger (soporta hasta 100! o más)
    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
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
    }
}
