import java.math.BigInteger;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class FactorialRecursivoTest {

    // Instancia única reutilizada para todos los tests
    private final FactorialRecursivo factorial = new FactorialRecursivo();

    // 🔹 Tests para multiplicar
    @Test
    void testMultiplicarCasoBase() {
        assertEquals(7, factorial.multiplicar(7, 1));
    }

    @Test
    void testMultiplicarPorCero() {
        assertEquals(0, factorial.multiplicar(7, 0));
    }

    @Test
    void testMultiplicarNumeroNormal() {
        assertEquals(12, factorial.multiplicar(3, 4));
    }

    @Test
    void testMultiplicarConNegativo() {
        assertEquals(-12, factorial.multiplicar(-3, 4));
        assertEquals(12, factorial.multiplicar(-3, -4));
    }

    // 🔹 Tests paramétricos para factorial con valores correctos
    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "5, 120",
        "7, 5040",
        "10, 3628800"
    })
    void testFactorialValoresValidos(int n, long esperado) {
        assertEquals(BigInteger.valueOf(esperado), factorial.factorial(n));
    }

    // 🔹 Tests para factorial con valores negativos (espera excepción)
    @ParameterizedTest
    @ValueSource(ints = {-1, -3, -10})
    void testFactorialNegativos(int n) {
        assertThrows(IllegalArgumentException.class, () -> {
            factorial.factorial(n);
        });
    }

    // 🔹 Test para factorial de un número grande
    @Test
    void testFactorialGrande() {
        BigInteger esperado = new BigInteger("2432902008176640000");
        assertEquals(esperado, factorial.factorial(20));
    }

    // 🔹 Test de rendimiento
    @Test
    void testPerformanceFactorial() {
        assertTimeout(Duration.ofMillis(100), () -> {
            factorial.factorial(15);
        });
    }

    // 🔹 Test para factorial de número muy grande (sin desbordamiento)
    @Test
    void testFactorialMuyGrande() {
        BigInteger resultado = factorial.factorial(100);
        assertTrue(resultado.compareTo(BigInteger.ZERO) > 0);
    }
}

