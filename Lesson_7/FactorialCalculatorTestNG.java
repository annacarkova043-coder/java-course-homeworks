import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FactorialCalculatorTestNG {
    
    private SoftAssert softAssert;
    
    @BeforeClass
    public void setUp() {
        System.out.println("Starting FactorialCalculator tests...");
    }
    
    @BeforeMethod
    public void setUpMethod() {
        softAssert = new SoftAssert();
    }
    
    @Test(priority = 1)
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1);
    }
    
    @Test(priority = 2)
    public void testFactorialOfOne() {
        Assert.assertEquals(FactorialCalculator.factorial(1), 1);
    }
    
    @Test(priority = 3, dataProvider = "factorialData")
    public void testFactorialOfPositiveNumbers(int input, long expected) {
        Assert.assertEquals(FactorialCalculator.factorial(input), expected);
    }
    
    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][] {
            {2, 2},
            {3, 6},
            {4, 24},
            {5, 120},
            {6, 720}
        };
    }
    
    @Test(priority = 4)
    public void testFactorialOfTen() {
        Assert.assertEquals(FactorialCalculator.factorial(10), 3628800L);
    }
    
    @Test(priority = 5)
    public void testRecursiveFactorial() {
        Assert.assertEquals(FactorialCalculator.factorialRecursive(5), 120);
        Assert.assertEquals(FactorialCalculator.factorialRecursive(6), 720);
    }
    
    @Test(priority = 6, expectedExceptions = IllegalArgumentException.class)
    public void testFactorialWithNegativeInput() {
        FactorialCalculator.factorial(-5);
    }
    
    @Test(priority = 7)
    public void testFactorialSafety() {
        Assert.assertTrue(FactorialCalculator.isFactorialSafe(20));
        Assert.assertFalse(FactorialCalculator.isFactorialSafe(21));
    }
    
    @Test(priority = 8)
    public void testBothMethodsReturnSameResult() {
        for (int i = 0; i <= 10; i++) {
            softAssert.assertEquals(
                FactorialCalculator.factorial(i),
                FactorialCalculator.factorialRecursive(i)
            );
        }
        softAssert.assertAll();
    }
    
    @Test(priority = 9, invocationCount = 5)
    public void repeatedTest() {
        Assert.assertEquals(FactorialCalculator.factorial(4), 24);
    }
    
    @Test(priority = 10, timeOut = 1000)
    public void testPerformance() {
        FactorialCalculator.factorial(20);
    }
    
    @AfterMethod
    public void tearDownMethod() {
        System.out.println("Completed a test method");
    }
    
    @AfterClass
    public void tearDown() {
        System.out.println("Completed all FactorialCalculator tests");
    }
}