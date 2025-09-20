package com.example;

public class FactorialRecursivo {

    // Multiplicación recursiva mejorada usando "multiplicación rusa"
    public static long multiplicar(long x, long y) {
        if (y == 0) return 0;
        if (y < 0) return -multiplicar(x, -y); // Manejo de negativos

        if (y % 2 == 0) {
            // Si y es par, multiplicar x por y es lo mismo que multiplicar 2*x por y/2
            return multiplicar(x + x, y / 2);
        } else {
            // Si y es impar, sumamos x y multiplicamos x por y-1
            return x + multiplicar(x, y - 1);
        }
    }

    // Factorial recursivo que usa la multiplicación recursiva
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }
        if (n == 0 || n == 1) return 1;
        return multiplicar(n, factorial(n - 1));
    }

    public static void main(String[] args) {
        System.out.println("Factorial de 20: " + factorial(20)); // 2432902008176640000
        System.out.println("Multiplicación de -3 * -4: " + multiplicar(-3, -4)); // 12
    }
}
