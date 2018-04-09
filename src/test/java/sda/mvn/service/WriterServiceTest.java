package sda.mvn.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WriterServiceTest {

    private static WriterService writerService;

    @BeforeClass
    public static void prepareTests() {
        writerService = new WriterService();
    }

    @Test
    public void testOneName() {
        Assert.assertEquals("hello greeting not correct",
                writerService.write("gulci"),
                "Hello, gulci.");
    }

    @Test
    public void testNullName() {
        Assert.assertEquals("empty greeting not correct",
                writerService.write(null),
                "Hello, my friend.");
    }

    @Test
    public void testCapitalizedName() {
        Assert.assertEquals("greeting not in capital letters",
                writerService.write("GULCI"),
                "HELLO, GULCI!");
    }

    @Test
    public void testEmptyName() {
        Assert.assertEquals("empty name not displayed correctly",
                writerService.write(""),
                "Hello, my friend.");
    }

    @Test
    public void testBlankName() {
        Assert.assertEquals("blank name not displayed correctly",
                writerService.write("   "),
                "Hello, my friend.");
    }

    @Test
    public void testNames() {
        Assert.assertEquals("not all capitalized names not displayed correctly",
                writerService.write("Jan, ANNA, kasia"),
                "Hello, Jan, ANNA and kasia.");
    }

    @Test
    public void testCapitalizedNames() {
        Assert.assertEquals("all capitalized names not displayed correctly",
                writerService.write("JAN, ANNA, KASIA"),
                "HELLO, JAN, ANNA and KASIA!");
    }
}
