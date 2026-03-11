import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class NumberComparatorTestNG {
    
    private SoftAssert softAssert;
    
    @BeforeClass
    public void setUp() {
        System.out.println("Starting NumberComparator tests...");
    }
    
    @BeforeMethod
    public void setUpMethod() {
        softAssert = new SoftAssert();
    }
    
    @Test
    public void testCompare() {
        Assert.assertEquals(NumberComparator.compare(5, 3), 1);
        Assert.assertEquals(NumberComparator.compare(3, 5), -1);
        Assert.assertEquals(NumberComparator.compare(5, 5), 0);
    }
    
    @Test(dataProvider = "compareData")
    public void testCompareParameterized(int a, int b, int expected) {
        Assert.assertEquals(NumberComparator.compare(a, b), expected);
    }
    
    @DataProvider(name = "compareData")
    public Object[][] compareData() {
        return new Object[][] {
            {5, 3, 1},
            {3, 5, -1},
            {5, 5, 0},
            {-5, -3, -1},
            {-3, -5, 1}
        };
    }
    
    @Test
    public void testMax() {
        softAssert.assertEquals(NumberComparator.max(5, 3), 5);
        softAssert.assertEquals(NumberComparator.max(3, 5), 5);
        softAssert.assertEquals(NumberComparator.max(5, 5), 5);
        softAssert.assertAll();
    }
    
    @Test
    public void testMin() {
        softAssert.assertEquals(NumberComparator.min(5, 3), 3);
        softAssert.assertEquals(NumberComparator.min(3, 5), 3);
        softAssert.assertEquals(NumberComparator.min(5, 5), 5);
        softAssert.assertAll();
    }
    
    @Test
    public void testIsEqual() {
        Assert.assertTrue(NumberComparator.isEqual(5, 5));
        Assert.assertFalse(NumberComparator.isEqual(5, 3));
    }
    
    @Test
    public void testIsGreater() {
        Assert.assertTrue(NumberComparator.isGreater(5, 3));
        Assert.assertFalse(NumberComparator.isGreater(3, 5));
        Assert.assertFalse(NumberComparator.isGreater(5, 5));
    }
    
    @Test
    public void testIsLess() {
        Assert.assertTrue(NumberComparator.isLess(3, 5));
        Assert.assertFalse(NumberComparator.isLess(5, 3));
        Assert.assertFalse(NumberComparator.isLess(5, 5));
    }
    
    @Test(dataProvider = "rangeData")
    public void testIsInRange(int number, int min, int max, boolean expected) {
        Assert.assertEquals(NumberComparator.isInRange(number, min, max), expected);
    }
    
    @DataProvider(name = "rangeData")
    public Object[][] rangeData() {
        return new Object[][] {
            {5, 1, 10, true},
            {1, 1, 10, true},
            {10, 1, 10, true},
            {0, 1, 10, false},
            {11, 1, 10, false}
        };
    }
    
    @Test(groups = {"edge-cases"})
    public void testWithMaxValue() {
        Assert.assertEquals(NumberComparator.max(Integer.MAX_VALUE, 100), Integer.MAX_VALUE);
    }
    
    @Test(groups = {"edge-cases"})
    public void testWithMinValue() {
        Assert.assertEquals(NumberComparator.min(Integer.MIN_VALUE, 100), Integer.MIN_VALUE);
    }
    
    @Test(groups = {"edge-cases"})
    public void testWithNegativeNumbers() {
        softAssert.assertTrue(NumberComparator.isGreater(-5, -10));
        softAssert.assertTrue(NumberComparator.isLess(-10, -5));
        softAssert.assertAll();
    }
    
    @Test(dependsOnMethods = {"testCompare"})
    public void testDependsOnCompare() {
        // This test will run only if testCompare passes
        Assert.assertTrue(NumberComparator.isGreater(10, 5));
    }
}