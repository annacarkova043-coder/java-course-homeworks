import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArithmeticOperationsTest {
    
    @Test
    @Order(1)
    @DisplayName("Test addition")
    void testAdd() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
        assertEquals(-1, ArithmeticOperations.add(2, -3));
        assertEquals(0, ArithmeticOperations.add(-2, 2));
    }
    
    @ParameterizedTest
    @Order(2)
    @CsvSource({
        "5, 3, 2",
        "10, 4, 6",
        "0, 5, -5",
        "-3, -2, -1"
    })
    @DisplayName("Test subtraction with parameters")
    void testSubtract(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.subtract(a, b));
    }
    
    @Test
    @Order(3)
    @DisplayName("Test multiplication")
    void testMultiply() {
        assertEquals(6, ArithmeticOperations.multiply(2, 3));
        assertEquals(-6, ArithmeticOperations.multiply(2, -3));
        assertEquals(0, ArithmeticOperations.multiply(0, 5));
    }
    
    @Test
    @Order(4)
    @DisplayName("Test division")
    void testDivide() {
        assertEquals(2.5, ArithmeticOperations.divide(5, 2));
        assertEquals(-2.5, ArithmeticOperations.divide(-5, 2));
        assertEquals(0, ArithmeticOperations.divide(0, 5));
    }
    
    @Test
    @Order(5)
    @DisplayName("Test division by zero throws exception")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(5, 0));
    }
    
    @Test
    @Order(6)
    @DisplayName("Test power")
    void testPower() {
        assertEquals(8, ArithmeticOperations.power(2, 3));
        assertEquals(1, ArithmeticOperations.power(5, 0));
        assertEquals(100, ArithmeticOperations.power(10, 2));
    }
    
    @Test
    @Order(7)
    @DisplayName("Test power with negative exponent throws exception")
    void testPowerWithNegativeExponent() {
        assertThrows(IllegalArgumentException.class, 
            () -> ArithmeticOperations.power(2, -3));
    }
    
    @Test
    @Order(8)
    @DisplayName("Test modulo")
    void testModulo() {
        assertEquals(2, ArithmeticOperations.modulo(7, 5));
        assertEquals(0, ArithmeticOperations.modulo(10, 2));
    }
    
    @Test
    @Order(9)
    @DisplayName("Test modulo by zero throws exception")
    void testModuloByZero() {
        assertThrows(ArithmeticException.class, 
            () -> ArithmeticOperations.modulo(5, 0));
    }
    
    @Test
    @Order(10)
    @DisplayName("Test isEven and isOdd")
    void testEvenOdd() {
        assertTrue(ArithmeticOperations.isEven(4));
        assertFalse(ArithmeticOperations.isEven(5));
        assertTrue(ArithmeticOperations.isOdd(7));
        assertFalse(ArithmeticOperations.isOdd(8));
    }
    
    @Test
    @Order(11)
    @DisplayName("Test commutative property of addition")
    void testCommutativeProperty() {
        int a = 5, b = 7;
        assertEquals(
            ArithmeticOperations.add(a, b),
            ArithmeticOperations.add(b, a)
        );
    }
}