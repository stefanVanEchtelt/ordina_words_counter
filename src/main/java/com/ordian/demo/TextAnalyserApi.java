package com.ordian.demo;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TextAnalyserApi {

    private TextAnalyzerService textAnalyzerService;

    public TextAnalyserApi() {
        this.textAnalyzerService = new TextAnalyzerService();
    }

    @PostMapping("/highest/frequency")
    public int highestFrequencyWord(@RequestBody @NotNull String text) {
        return this.textAnalyzerService.calculateHighestFrequency(text);
    }

    @PostMapping("/frequency/{word}")
    public int wordFrequency(@PathVariable String word, @RequestBody @NotNull String text) {
        return this.textAnalyzerService.calculateFrequencyForWord(text, word);
    }

    @PostMapping("/frequent/{n}/words")
    public List<WordFrequency> test3(@PathVariable int n, @RequestBody @NotNull String text) {
        return this.textAnalyzerService.calculateMostFrequentNWords(text, n);
    }
}
