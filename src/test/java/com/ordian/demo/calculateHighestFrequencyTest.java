package com.ordian.demo;

import org.junit.Assert;
import org.junit.Test;

public class calculateHighestFrequencyTest {

    private TextAnalyzerService textAnalyzerService = new TextAnalyzerService();

    @Test
    public void emptyTextTest() {
        int result = textAnalyzerService.calculateHighestFrequency("");
        Assert.assertEquals(0, result);
    }

    @Test
    public void tabTest() {
        int result = textAnalyzerService.calculateHighestFrequency("This is a test    test sentence");
        Assert.assertEquals(2, result);
    }

    @Test
    public void doubleSpaceTest() {
        int result = textAnalyzerService.calculateHighestFrequency("This is  a  test  a  sentence");
        Assert.assertEquals(2, result);
    }

    @Test
    public void oneSameWordTest() {
        int result = textAnalyzerService.calculateHighestFrequency("The sun shines over");
        Assert.assertEquals(1, result);
    }

    @Test
    public void threeSameWordTest() {
        int result = textAnalyzerService.calculateHighestFrequency("The sun shines over the lake where the water lands");
        Assert.assertEquals(3, result);
    }
}
