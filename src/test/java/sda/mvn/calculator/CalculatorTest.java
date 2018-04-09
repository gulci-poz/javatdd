package sda.mvn.calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        int sum = calculator.sum(3, 5);
        Assert.assertEquals("result is not 8", sum, 8);
    }
}
