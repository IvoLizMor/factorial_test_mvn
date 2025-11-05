package com.grupo;

import com.grupo.errors.ErrorMessages;
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
                        <input type="text" id="n" name="n">
                        <input type="submit" value="Calcular factorial">
                    </form>
                </body>
            </html>
            """;
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "n", required = false) String raw) {

        // Campo vacío
        if (raw == null || raw.isBlank()) {
            System.out.println("[ERROR] " + ErrorMessages.VAC);
            return ErrorMessages.VAC;
        }

        // No numérico
        if (!raw.matches("^-?\\d+$")) {
            System.out.println("[ERROR] " + ErrorMessages.INV);
            return ErrorMessages.INV;
        }

        int n = Integer.parseInt(raw);

        // Negativo (lo valida también la lógica recursiva)
        if (n < 0) {
            System.out.println("[ERROR] " + ErrorMessages.NEG);
            return ErrorMessages.NEG;
        }

        return "El factorial de " + n + " es " + factorialRecursivo(n);
    }

    private long factorialRecursivo(int n) {
        if (n <= 1) return 1;
        return n * factorialRecursivo(n - 1);
    }
}
