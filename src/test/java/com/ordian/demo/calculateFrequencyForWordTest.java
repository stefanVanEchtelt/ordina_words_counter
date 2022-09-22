package com.ordian.demo;

import org.junit.Assert;
import org.junit.Test;

public class calculateFrequencyForWordTest {

    private TextAnalyzerService textAnalyzerService = new TextAnalyzerService();

    @Test
    public void emptyTextTest() {
        int result = textAnalyzerService.calculateFrequencyForWord("", "test");
        Assert.assertEquals(0, result);
    }

    @Test
    public void emptyWordTest() {
        int result = textAnalyzerService.calculateFrequencyForWord("This is a test sentence", "");
        Assert.assertEquals(0, result);
    }

    @Test
    public void bothEmptyTest() {
        int result = textAnalyzerService.calculateFrequencyForWord("", "");
        Assert.assertEquals(0, result);
    }

    @Test
    public void tabTest() {
        int result = textAnalyzerService.calculateFrequencyForWord("This is a    test sentence", "test");
        Assert.assertEquals(1, result);
    }

    @Test
    public void doubleSpaceTest() {
        int result = textAnalyzerService.calculateFrequencyForWord("This is  a  test sentence", " a");
        Assert.assertEquals(0, result);
    }

    @Test
    public void noWordTest() {
        int result = textAnalyzerService.calculateFrequencyForWord("This is the 1e test 1e sentence", "1");
        Assert.assertEquals(0, result);
    }

    @Test
    public void noWordCenterCharTest() {
        int result = textAnalyzerService.calculateFrequencyForWord("This is the sen1tence", "sentence");
        Assert.assertEquals(0, result);
    }

    @Test
    public void oneWordFoundTest() {
        int result = textAnalyzerService.calculateFrequencyForWord("This is the example test", "example");
        Assert.assertEquals(1, result);
    }

    @Test
    public void oneWordFoundEndTest() {
        int result = textAnalyzerService.calculateFrequencyForWord("This is the example test", "test");
        Assert.assertEquals(1, result);
    }

    @Test
    public void threeWordsFoundTest() {
        int result = textAnalyzerService.calculateFrequencyForWord("This is a example test for a users that is a programmer", "a");
        Assert.assertEquals(3, result);
    }

    @Test
    public void tWordsFoundTest() {
        int result = textAnalyzerService.calculateFrequencyForWord(" test asdsa cas cas cas casc cas", "cas");
        Assert.assertEquals(4, result);
    }
}
