import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FactorialCalculatorTest {
    
    @Test
    @Order(1)
    @DisplayName("Test factorial of 0")
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.factorial(0));
    }
    
    @Test
    @Order(2)
    @DisplayName("Test factorial of 1")
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.factorial(1));
    }
    
    @ParameterizedTest
    @Order(3)
    @CsvSource({
        "2, 2",
        "3, 6",
        "4, 24",
        "5, 120",
        "6, 720"
    })
    @DisplayName("Test factorial of positive numbers")
    void testFactorialOfPositiveNumbers(int input, long expected) {
        assertEquals(expected, FactorialCalculator.factorial(input));
    }
    
    @Test
    @Order(4)
    @DisplayName("Test factorial of 10")
    void testFactorialOfTen() {
        assertEquals(3628800, FactorialCalculator.factorial(10));
    }
    
    @Test
    @Order(5)
    @DisplayName("Test recursive factorial")
    void testRecursiveFactorial() {
        assertEquals(120, FactorialCalculator.factorialRecursive(5));
        assertEquals(720, FactorialCalculator.factorialRecursive(6));
    }
    
    @Test
    @Order(6)
    @DisplayName("Test factorial with negative input throws exception")
    void testFactorialWithNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.factorial(-5));
    }
    
    @Test
    @Order(7)
    @DisplayName("Test factorial safety check")
    void testFactorialSafety() {
        assertTrue(FactorialCalculator.isFactorialSafe(20));
        assertFalse(FactorialCalculator.isFactorialSafe(21));
    }
    
    @Test
    @Order(8)
    @DisplayName("Test both methods return same result")
    void testBothMethodsReturnSameResult() {
        for (int i = 0; i <= 10; i++) {
            assertEquals(
                FactorialCalculator.factorial(i),
                FactorialCalculator.factorialRecursive(i)
            );
        }
    }
    
    @RepeatedTest(5)
    @Order(9)
    @DisplayName("Repeated test for consistency")
    void repeatedTest() {
        assertEquals(24, FactorialCalculator.factorial(4));
    }
    
    @Test
    @Order(10)
    @Timeout(1)
    @DisplayName("Test performance")
    void testPerformance() {
        FactorialCalculator.factorial(20);
    }
}