package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSessionTest {
    @Test
    public void applyOneSession() {
        assertEquals(
                1,
                new CountSession().apply(List.of(new SleepingSession(null, null, null))).value
        );
    }

    @Test
    public void applyTwoSession() {
        assertEquals(
                2,
                new CountSession().apply(List.of(new SleepingSession(null, null, null), new SleepingSession(null, null, null))).value
        );
    }
}