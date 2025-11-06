package com.grupo.steps;

import io.cucumber.java.es.*;
import static org.junit.jupiter.api.Assertions.*;

import com.grupo.errors.FactorialRecursivo; // ✅ ajustado al paquete real (según tu estructura)
import java.math.BigInteger;

public class AppSteps {

    private String entrada;
    private BigInteger resultado;
    private String mensajeError;

    @Dado("que ingreso el número {string}")
    public void que_ingreso_el_numero(String numero) {
        this.entrada = numero;
    }

    @Dado("no ingreso ningún valor")
    public void no_ingreso_ningun_valor() {
        this.entrada = "";
    }

    @Cuando("solicito calcular el factorial")
    public void solicito_calcular_el_factorial() {
        try {
            if (entrada == null || entrada.isEmpty()) {
                throw new IllegalArgumentException("Debe ingresar un número");
            }

            int n = Integer.parseInt(entrada);
            if (n < 0) {
                throw new IllegalArgumentException("El número debe ser positivo");
            }

            resultado = FactorialRecursivo.factorial(n);

        } catch (NumberForma
