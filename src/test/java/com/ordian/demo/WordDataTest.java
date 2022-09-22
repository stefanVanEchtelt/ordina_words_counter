package com.ordian.demo;

import org.junit.Test;
import org.junit.Assert;

public class WordDataTest {

    @Test
    public void wordTest() {
        WordData word = new WordData("test", 0);
        Assert.assertEquals(word.getWord(), "test");
    }

    @Test
    public void frequencyTest() {
        WordData word = new WordData("test", 3);
        Assert.assertEquals(word.getFrequency(), 3);
    }
}
