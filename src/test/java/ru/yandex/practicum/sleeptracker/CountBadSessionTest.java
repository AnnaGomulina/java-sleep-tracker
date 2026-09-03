package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountBadSessionTest {
    @Test
    public void applyZeroSession() {
        assertEquals(
                new SleepAnalysisResult("Количество сессий с плохим качеством сна равно: ", 0),
                new CountBadSession().apply(List.of(new SleepingSession(null, null, null)))
        );
    }

    @Test
    public void applyOneSession() {
        assertEquals(
                new SleepAnalysisResult("Количество сессий с плохим качеством сна равно: ", 1),
                new CountBadSession().apply(List.of(new SleepingSession(null, null, null),
                        new SleepingSession(null, null, SleepingSession.Estimation.BAD)))
        );
    }

    @Test
    public void applyTwoSession() {
        assertEquals(
                new SleepAnalysisResult("Количество сессий с плохим качеством сна равно: ", 2),
                new CountBadSession().apply(List.of(new SleepingSession(null, null, null),
                        new SleepingSession(null, null, SleepingSession.Estimation.BAD),
                        new SleepingSession(null, null, SleepingSession.Estimation.BAD)))
        );
    }
}