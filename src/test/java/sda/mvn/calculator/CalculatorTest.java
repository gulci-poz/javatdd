package sda.mvn.calculator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeClass
    public static void prepareTests() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        Assert.assertEquals("result is not 8", calculator.sum(3, 5), 8);
    }

    @Test
    public void testsub() {
        Assert.assertEquals("result is not -2", calculator.sub(3, 5), -2);
    }

    @Test
    public void testMult() {
        Assert.assertEquals("result is not 15", calculator.mult(3, 5), 15);
    }

    @Test
    public void testDiv() {
        Assert.assertEquals("result is not 5", calculator.div(11, 2), 5);
    }
}
