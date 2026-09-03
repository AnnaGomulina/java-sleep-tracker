package ru.yandex.practicum.sleeptracker;

import java.util.Objects;

public class SleepAnalysisResult {
    String text;
    int value;

    public SleepAnalysisResult(String text, int value) {
        this.text = text;
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        SleepAnalysisResult that = (SleepAnalysisResult) object;
        return value == that.value && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, value);
    }
}

