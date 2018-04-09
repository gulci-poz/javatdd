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
                "Hello, gulci!");
    }

    @Test
    public void testEmptyName() {
        Assert.assertEquals("empty greeting not correct",
                writerService.write(null),
                "Hello, my friend!");
    }
}
