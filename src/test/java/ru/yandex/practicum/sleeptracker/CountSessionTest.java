package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountSessionTest {
    @Test
    public void applyOneSession() {
        assertEquals(
                new SleepAnalysisResult("Количество сна в этой сессии равно: ", 1),
                new CountSession().apply(List.of(new SleepingSession(null, null, null)))
        );
    }

    @Test
    public void applyTwoSession() {
        assertEquals(
                new SleepAnalysisResult("Количество сна в этой сессии равно: ", 2),
                new CountSession().apply(List.of(new SleepingSession(null, null, null), new SleepingSession(null, null, null)))
        );
    }
}