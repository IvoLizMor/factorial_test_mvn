package com.example;

public class FactorialRecursivo {

    // Multiplicación definida de manera recursiva:
    // x * p = x + x + ... + x (p veces)
    public static int multiplicar(int x, int p) {
        if (p < 0) {
            throw new IllegalArgumentException("La multiplicación no está definida para potencias negativas");
        }
        if (p == 0) {
            return 0; // caso base: x * 0 = 0
        }
        if (p == 1) {
            return x; // caso base: x * 1 = x
        }
        return x + multiplicar(x, p - 1); // caso recursivo
    }

    // Factorial definido de manera recursiva usando "multiplicar"
    // factorial(n) = n * factorial(n-1)
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }
        if (n == 0 || n == 1) {
            return 1; // casos base
        }
        return multiplicar(n, factorial(n - 1)); // caso recursivo
    }

    // Método de prueba
    public static void main(String[] args) {
        System.out.println("Factorial de 5: " + factorial(5)); // debería dar 120
        System.out.println("Multiplicación de 7 * 4: " + multiplicar(7, 4)); // debería dar 28
    }
}
