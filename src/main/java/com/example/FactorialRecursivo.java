package com.example;

public class FactorialRecursivo {

    // Multiplicación recursiva usando long para evitar desbordamiento
    public static long multiplicar(long x, long p) {
        if (p == 0) return 0;
        if (p > 0) return x + multiplicar(x, p - 1);
        return -multiplicar(x, -p); // Manejo de negativos
    }

    // Factorial usando multiplicar con long
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }

        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado = multiplicar(resultado, i);
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Factorial de 20: " + factorial(20)); // 2432902008176640000
        System.out.println("Multiplicación de -3 * -4: " + multiplicar(-3, -4)); // 12
    }
}
