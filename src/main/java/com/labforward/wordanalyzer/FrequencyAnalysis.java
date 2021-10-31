package com.labforward.wordanalyzer;

/**
 * Defines a FrequencyAnalysis object
 */
public class FrequencyAnalysis {
    private final long frequency;
    private final String[] similarities;

    public FrequencyAnalysis(long frequency, String[] similarities) {
        this.frequency = frequency;
        this.similarities = similarities;
    }

    public long getFrequency() {
        return frequency;
    }

    public String[] getSimilarities() {
        return similarities;
    }
}
