import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NumberComparatorTest {
    
    @Test
    @Order(1)
    @DisplayName("Test compare method")
    void testCompare() {
        assertEquals(1, NumberComparator.compare(5, 3));
        assertEquals(-1, NumberComparator.compare(3, 5));
        assertEquals(0, NumberComparator.compare(5, 5));
    }
    
    @ParameterizedTest
    @Order(2)
    @CsvSource({
        "5, 3, 1",
        "3, 5, -1",
        "5, 5, 0",
        "-5, -3, -1",
        "-3, -5, 1"
    })
    @DisplayName("Test compare with parameters")
    void testCompareParameterized(int a, int b, int expected) {
        assertEquals(expected, NumberComparator.compare(a, b));
    }
    
    @Test
    @Order(3)
    @DisplayName("Test max method")
    void testMax() {
        assertEquals(5, NumberComparator.max(5, 3));
        assertEquals(5, NumberComparator.max(3, 5));
        assertEquals(5, NumberComparator.max(5, 5));
    }
    
    @Test
    @Order(4)
    @DisplayName("Test min method")
    void testMin() {
        assertEquals(3, NumberComparator.min(5, 3));
        assertEquals(3, NumberComparator.min(3, 5));
        assertEquals(5, NumberComparator.min(5, 5));
    }
    
    @Test
    @Order(5)
    @DisplayName("Test isEqual method")
    void testIsEqual() {
        assertTrue(NumberComparator.isEqual(5, 5));
        assertFalse(NumberComparator.isEqual(5, 3));
    }
    
    @Test
    @Order(6)
    @DisplayName("Test isGreater method")
    void testIsGreater() {
        assertTrue(NumberComparator.isGreater(5, 3));
        assertFalse(NumberComparator.isGreater(3, 5));
        assertFalse(NumberComparator.isGreater(5, 5));
    }
    
    @Test
    @Order(7)
    @DisplayName("Test isLess method")
    void testIsLess() {
        assertTrue(NumberComparator.isLess(3, 5));
        assertFalse(NumberComparator.isLess(5, 3));
        assertFalse(NumberComparator.isLess(5, 5));
    }
    
    @Test
    @Order(8)
    @DisplayName("Test isInRange method")
    void testIsInRange() {
        assertTrue(NumberComparator.isInRange(5, 1, 10));
        assertTrue(NumberComparator.isInRange(1, 1, 10));
        assertTrue(NumberComparator.isInRange(10, 1, 10));
        assertFalse(NumberComparator.isInRange(0, 1, 10));
        assertFalse(NumberComparator.isInRange(11, 1, 10));
    }
    
    @Nested
    @DisplayName("Edge Cases")
    class EdgeCases {
        
        @Test
        @DisplayName("Test with Integer.MAX_VALUE")
        void testMaxValue() {
            assertEquals(Integer.MAX_VALUE, 
                NumberComparator.max(Integer.MAX_VALUE, 100));
        }
        
        @Test
        @DisplayName("Test with Integer.MIN_VALUE")
        void testMinValue() {
            assertEquals(Integer.MIN_VALUE, 
                NumberComparator.min(Integer.MIN_VALUE, 100));
        }
        
        @Test
        @DisplayName("Test with negative numbers")
        void testWithNegatives() {
            assertTrue(NumberComparator.isGreater(-5, -10));
            assertTrue(NumberComparator.isLess(-10, -5));
        }
    }
}