package com.ordian.demo;

public class WordData implements WordFrequency {
    private String word;
    private int frequency;

    public WordData(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return this.word;
    }

    public int getFrequency() {
        return this.frequency;
    }

    @Override
    public String toString() {
        return "WordData{" +
                "word='" + word + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
