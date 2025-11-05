package com.grupo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AppSteps {

    @Given("que el sistema está disponible")
    public void sistemaDisponible() {
        // por ahora no hace nada
    }

    @When("el usuario solicita calcular el factorial de {int}")
    public void solicitarFactorial(int n) {
        // por ahora no hace nada
    }

    @Then("el resultado debe ser mostrado correctamente")
    public void resultadoMostrado() {
        // por ahora no hace nada
    }
}
