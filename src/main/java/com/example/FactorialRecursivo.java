package com.example;

public class FactorialRecursivo {

    // Multiplicación definida de manera recursiva, incluyendo negativos
    public static int multiplicar(int x, int p) {
        if (p == 0) return 0;
        if (p > 0) return x + multiplicar(x, p - 1);
        return -multiplicar(x, -p); // Manejo de negativos
    }

    // Factorial definido de manera recursiva usando "multiplicar"
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return multiplicar(n, (int) factorial(n - 1));
    }

    public static void main(String[] args) {
        System.out.println("Factorial de 5: " + factorial(5)); // 120
        System.out.println("Multiplicación de -3 * 4: " + multiplicar(-3, 4)); // -12
        System.out.println("Multiplicación de -3 * -4: " + multiplicar(-3, -4)); // 12
    }
}
