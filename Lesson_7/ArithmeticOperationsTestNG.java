import org.testng.annotations.*;
import org.testng.Assert;

public class ArithmeticOperationsTestNG {
    
    @BeforeClass
    public void setUp() {
        System.out.println("Starting ArithmeticOperations tests...");
    }
    
    @Test
    public void testAdd() {
        Assert.assertEquals(ArithmeticOperations.add(2, 3), 5);
        Assert.assertEquals(ArithmeticOperations.add(2, -3), -1);
        Assert.assertEquals(ArithmeticOperations.add(-2, 2), 0);
    }
    
    @Test(dataProvider = "subtractData")
    public void testSubtract(int a, int b, int expected) {
        Assert.assertEquals(ArithmeticOperations.subtract(a, b), expected);
    }
    
    @DataProvider(name = "subtractData")
    public Object[][] subtractData() {
        return new Object[][] {
            {5, 3, 2},
            {10, 4, 6},
            {0, 5, -5},
            {-3, -2, -1}
        };
    }
    
    @Test
    public void testMultiply() {
        Assert.assertEquals(ArithmeticOperations.multiply(2, 3), 6);
        Assert.assertEquals(ArithmeticOperations.multiply(2, -3), -6);
        Assert.assertEquals(ArithmeticOperations.multiply(0, 5), 0);
    }
    
    @Test
    public void testDivide() {
        Assert.assertEquals(ArithmeticOperations.divide(5, 2), 2.5);
        Assert.assertEquals(ArithmeticOperations.divide(-5, 2), -2.5);
        Assert.assertEquals(ArithmeticOperations.divide(0, 5), 0.0);
    }
    
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        ArithmeticOperations.divide(5, 0);
    }
    
    @Test(dataProvider = "powerData")
    public void testPower(int a, int b, long expected) {
        Assert.assertEquals(ArithmeticOperations.power(a, b), expected);
    }
    
    @DataProvider(name = "powerData")
    public Object[][] powerData() {
        return new Object[][] {
            {2, 3, 8},
            {5, 0, 1},
            {10, 2, 100}
        };
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testPowerWithNegativeExponent() {
        ArithmeticOperations.power(2, -3);
    }
    
    @Test
    public void testModulo() {
        Assert.assertEquals(ArithmeticOperations.modulo(7, 5), 2);
        Assert.assertEquals(ArithmeticOperations.modulo(10, 2), 0);
    }
    
    @Test(expectedExceptions = ArithmeticException.class)
    public void testModuloByZero() {
        ArithmeticOperations.modulo(5, 0);
    }
    
    @Test
    public void testEvenOdd() {
        Assert.assertTrue(ArithmeticOperations.isEven(4));
        Assert.assertFalse(ArithmeticOperations.isEven(5));
        Assert.assertTrue(ArithmeticOperations.isOdd(7));
        Assert.assertFalse(ArithmeticOperations.isOdd(8));
    }
    
    @Test(invocationCount = 3)
    public void testCommutativeProperty() {
        int a = 5, b = 7;
        Assert.assertEquals(
            ArithmeticOperations.add(a, b),
            ArithmeticOperations.add(b, a)
        );
    }
    
    @Test(groups = {"smoke"})
    public void smokeTestAdd() {
        Assert.assertEquals(ArithmeticOperations.add(1, 1), 2);
    }
}