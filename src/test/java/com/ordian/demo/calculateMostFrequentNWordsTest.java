package com.ordian.demo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class calculateMostFrequentNWordsTest {

    private TextAnalyzerService textAnalyzerService = new TextAnalyzerService();

    @Test
    public void emptyN() {
        List<WordFrequency> result = textAnalyzerService.calculateMostFrequentNWords("The sun shines over the lake", 0);

        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void sentence() {
        List<WordFrequency> result = textAnalyzerService.calculateMostFrequentNWords("", 3);

        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void checkSameLength() {
        List<WordFrequency> result = textAnalyzerService.calculateMostFrequentNWords("The sun shines over the lake", 3);

        Assert.assertEquals(result.size(), 3);
    }

    @Test
    public void checkSmallerLength() {
        List<WordFrequency> result = textAnalyzerService.calculateMostFrequentNWords("The sun", 3);

        Assert.assertEquals(result.size(), 2);
    }

    @Test
    public void compareData() {
        List<WordFrequency> wordDataList = new ArrayList<>();
        wordDataList.add(new WordData("the", 2));
        wordDataList.add(new WordData("lake", 1));
        wordDataList.add(new WordData("over", 1));

        List<WordFrequency> result = textAnalyzerService.calculateMostFrequentNWords("The sun shines over the lake", 3);

        for(int i = 0; i < result.size(); i++) {
            Assert.assertEquals(wordDataList.get(i).toString(), result.get(i).toString());
        }
    }
}
