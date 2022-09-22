package com.ordian.demo;

import java.util.*;
import java.util.stream.Stream;

public class TextAnalyzerService implements WordFrequencyAnalyzer {

    private HashMap<String, Integer> countTextWords(String text) {
        HashMap<String, Integer> wordsCounter = new HashMap<>();
        String[] splitText = text.trim().toLowerCase().split(" ");

        for (String word: splitText) {
            if (word.matches("[a-zA-Z]+")) {
                wordsCounter.put(word, wordsCounter.getOrDefault(word, 0) + 1);
            }
        }

        return wordsCounter;
    }

    public int calculateHighestFrequency(String text) {
        HashMap<String, Integer> wordsCounter = this.countTextWords(text);
        int highest = 0;

        for (int value: wordsCounter.values()) {
            if (highest < value) {
                highest = value;
            }
        }

        return highest;
    }

    public int calculateFrequencyForWord(String text, String word) {
        if (word.isEmpty() || !word.matches("[a-zA-Z]+")) {
            return 0;
        }

        // This could be used parallel but not necessary for small text
        String finalWord = word.trim();
        return (int) Stream.of(text.trim().toLowerCase().split(" "))
                .filter(s -> s.matches("[a-zA-Z]+"))
                .filter(s -> s.equals(finalWord))
                .count();
    }

    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        List<WordFrequency> wordFrequencyList = new ArrayList<>();
        HashMap<String, Integer> wordsCounter = this.countTextWords(text);

        wordsCounter.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed().thenComparing(Map.Entry::getKey))
                .forEach(e -> wordFrequencyList.add(new WordData(e.getKey(), e.getValue())));

        if (wordFrequencyList.size() > n) {
            return wordFrequencyList.subList(0, n);
        }

        return wordFrequencyList;
    }
}
