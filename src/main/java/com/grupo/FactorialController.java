package com.grupo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    @GetMapping("/")
    public String home() {
        return """
            <html>
                <head>
                    <title>Calculadora de Factorial</title>
                </head>
                <body>
                    <h2>✅ Aplicación de Factorial corriendo correctamente en Azure!</h2>
                    <form action="/factorial" method="get">
                        <label for="n">Ingresa un número:</label>
                        <input type="number" id="n" name="n" min="0" required>
                        <input type="submit" value="Calcular factorial">
                    </form>
                </body>
            </html>
            """;
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "n", defaultValue = "5") int n) {
        if (n < 0) {
            return ErrorMessages.NEG;
        }
        return "El factorial de " + n + " es " + factorialRecursivo(n);
    }

    private long factorialRecursivo(int n) {
        if (n <= 1) return 1;
        return n * factorialRecursivo(n - 1);
    }
}
