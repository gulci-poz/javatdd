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
        Assert.assertEquals("not adding properly", 102, stringCalculator.sumString("99,  3"));
        Assert.assertEquals("not adding properly", 21, stringCalculator.sumString("4, 17"));
        Assert.assertEquals("not adding properly", 28, stringCalculator.sumString("21,7"));
        Assert.assertEquals("not adding properly",
                428,
                stringCalculator.sumString("21,7, 43,    34,  323")
        );
    }

    @Test
    public void sumStringNull() {
        Assert.assertEquals("not adding properly for blank or null",
                0,
                stringCalculator.sumString(null)
        );
    }

    @Test
    public void sumStringBlank() {
        Assert.assertEquals("not adding properly for blank or null",
                0,
                stringCalculator.sumString("")
        );
    }
}
