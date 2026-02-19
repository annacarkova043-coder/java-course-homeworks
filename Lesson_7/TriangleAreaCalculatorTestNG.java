import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TriangleAreaCalculatorTestNG {
    
    private SoftAssert softAssert;
    
    @BeforeClass
    public void setUp() {
        System.out.println("Starting TriangleAreaCalculator tests...");
    }
    
    @BeforeMethod
    public void setUpMethod() {
        softAssert = new SoftAssert();
    }
    
    @Test
    public void testAreaByBaseAndHeight() {
        Assert.assertEquals(TriangleAreaCalculator.areaByBaseAndHeight(5, 4), 10.0);
        Assert.assertEquals(TriangleAreaCalculator.areaByBaseAndHeight(5, 3), 7.5);
    }
    
    @Test(dataProvider = "triangleData")
    public void testAreaByThreeSides(double a, double b, double c, double expected) {
        double result = TriangleAreaCalculator.areaByThreeSides(a, b, c);
        Assert.assertEquals(result, expected, 0.0001);
    }
    
    @DataProvider(name = "triangleData")
    public Object[][] triangleData() {
        return new Object[][] {
            {3, 4, 5, 6.0},
            {5, 5, 6, 12.0},
            {7, 8, 9, 26.8328}
        };
    }
    
    @Test
    public void testAreaOfRightTriangle() {
        softAssert.assertEquals(TriangleAreaCalculator.areaOfRightTriangle(3, 4), 6.0);
        softAssert.assertEquals(TriangleAreaCalculator.areaOfRightTriangle(5, 4), 10.0);
        softAssert.assertAll();
    }
    
    @Test
    public void testAreaOfEquilateralTriangle() {
        double side = 4;
        double expected = (Math.sqrt(3) / 4) * 16;
        Assert.assertEquals(TriangleAreaCalculator.areaOfEquilateralTriangle(4), expected, 0.0001);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTriangleSides() {
        TriangleAreaCalculator.areaByThreeSides(1, 2, 10);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeBase() {
        TriangleAreaCalculator.areaByBaseAndHeight(-5, 4);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testZeroHeight() {
        TriangleAreaCalculator.areaByBaseAndHeight(5, 0);
    }
    
    @Test
    public void testEquilateralWithHeron() {
        double side = 6;
        double heronResult = TriangleAreaCalculator.areaByThreeSides(side, side, side);
        double equilateralResult = TriangleAreaCalculator.areaOfEquilateralTriangle(side);
        Assert.assertEquals(heronResult, equilateralResult, 0.0001);
    }
    
    @Test(groups = {"edge-cases"})
    public void testVerySmallTriangle() {
        double result = TriangleAreaCalculator.areaByThreeSides(0.001, 0.001, 0.001);
        Assert.assertTrue(result > 0);
    }
    
    @Test(groups = {"edge-cases"})
    public void testNearEquilateralTriangle() {
        double result = TriangleAreaCalculator.areaByThreeSides(5.0001, 5, 5);
        Assert.assertTrue(result > 0);
    }
}