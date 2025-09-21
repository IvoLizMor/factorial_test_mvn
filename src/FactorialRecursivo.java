package com.example;
 
import java.math.BigInteger;
 
public class FactorialRecursivo {
 
    // Multiplicación recursiva usando long (se conserva para los tests existentes)

    public static long multiplicar(long x, long p) {

        if (p == 0) return 0;

        if (p > 0) return x + multiplicar(x, p - 1);

        return -multiplicar(x, -p); // Manejo de negativos

    }
 
    // Factorial implementado con BigInteger (soporta valores grandes sin desbordamiento)

    public static BigInteger factorial(int n) {

        if (n < 0) {

            throw new IllegalArgumentException("n debe ser >= 0");

        }
 
        BigInteger resultado = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {

            resultado = resultado.multiply(BigInteger.valueOf(i));

        }

        return resultado;

    }
 
    public static void main(String[] args) {

        System.out.println("Factorial de 20 (BigInteger): " + factorial(20));

        System.out.println("Multiplicación de -3 * -4 (long): " + multiplicar(-3, -4));

    }

}

 
