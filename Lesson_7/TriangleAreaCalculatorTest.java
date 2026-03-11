import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TriangleAreaCalculatorTest {
    
    @Test
    @Order(1)
    @DisplayName("Test area by base and height")
    void testAreaByBaseAndHeight() {
        assertEquals(10.0, TriangleAreaCalculator.areaByBaseAndHeight(5, 4));
        assertEquals(7.5, TriangleAreaCalculator.areaByBaseAndHeight(5, 3));
    }
    
    @ParameterizedTest
    @Order(2)
    @CsvSource({
        "3, 4, 5, 6.0",
        "5, 5, 6, 12.0",
        "7, 8, 9, 26.8328"
    })
    @DisplayName("Test area by three sides (Heron's formula)")
    void testAreaByThreeSides(double a, double b, double c, double expected) {
        double result = TriangleAreaCalculator.areaByThreeSides(a, b, c);
        assertEquals(expected, result, 0.0001);
    }
    
    @Test
    @Order(3)
    @DisplayName("Test area of right triangle")
    void testAreaOfRightTriangle() {
        assertEquals(6.0, TriangleAreaCalculator.areaOfRightTriangle(3, 4));
        assertEquals(10.0, TriangleAreaCalculator.areaOfRightTriangle(5, 4));
    }
    
    @Test
    @Order(4)
    @DisplayName("Test area of equilateral triangle")
    void testAreaOfEquilateralTriangle() {
        double side = 4;
        double expected = (Math.sqrt(3) / 4) * 16;
        assertEquals(expected, TriangleAreaCalculator.areaOfEquilateralTriangle(4), 0.0001);
    }
    
    @Test
    @Order(5)
    @DisplayName("Test invalid triangle sides throw exception")
    void testInvalidTriangleSides() {
        assertThrows(IllegalArgumentException.class, 
            () -> TriangleAreaCalculator.areaByThreeSides(1, 2, 10));
    }
    
    @Test
    @Order(6)
    @DisplayName("Test negative base throws exception")
    void testNegativeBase() {
        assertThrows(IllegalArgumentException.class, 
            () -> TriangleAreaCalculator.areaByBaseAndHeight(-5, 4));
    }
    
    @Test
    @Order(7)
    @DisplayName("Test zero height throws exception")
    void testZeroHeight() {
        assertThrows(IllegalArgumentException.class, 
            () -> TriangleAreaCalculator.areaByBaseAndHeight(5, 0));
    }
    
    @Test
    @Order(8)
    @DisplayName("Test equilateral triangle with Heron's formula")
    void testEquilateralWithHeron() {
        double side = 6;
        double heronResult = TriangleAreaCalculator.areaByThreeSides(side, side, side);
        double equilateralResult = TriangleAreaCalculator.areaOfEquilateralTriangle(side);
        assertEquals(heronResult, equilateralResult, 0.0001);
    }
    
    @Nested
    @DisplayName("Edge Cases")
    class EdgeCases {
        
        @Test
        @DisplayName("Test very small triangle")
        void testVerySmallTriangle() {
            double result = TriangleAreaCalculator.areaByThreeSides(0.001, 0.001, 0.001);
            assertTrue(result > 0);
        }
        
        @Test
        @DisplayName("Test near-equilateral triangle")
        void testNearEquilateral() {
            double result = TriangleAreaCalculator.areaByThreeSides(5.0001, 5, 5);
            assertTrue(result > 0);
        }
    }
}