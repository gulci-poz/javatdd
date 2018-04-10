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
        Assert.assertEquals(
                "not adding properly",
                stringCalculator.sumString("2, 3"),
                5
        );
    }
}
