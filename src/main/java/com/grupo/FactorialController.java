package com.grupo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    @GetMapping("/")
    public String home() {
        return "✅ Aplicación de Factorial corriendo correctamente en Azure!";
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "n", defaultValue = "5") int n) {
        if (n < 0) {
            return "El número debe ser no negativo.";
        }
        return "El factorial de " + n + " es " + factorialRecursivo(n);
    }

    private long factorialRecursivo(int n) {
        if (n <= 1) return 1;
        return n * factorialRecursivo(n - 1);
    }
}
