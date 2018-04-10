package sda.mvn.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @Before
    public void initializeTests() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void sumStringTest() {
        Assert.assertEquals("not adding properly", stringCalculator.sumString("99,  3"), 102);
        Assert.assertEquals("not adding properly", stringCalculator.sumString("4, 17"), 21);
        Assert.assertEquals("not adding properly", stringCalculator.sumString("21,7"), 28);
    }
}
