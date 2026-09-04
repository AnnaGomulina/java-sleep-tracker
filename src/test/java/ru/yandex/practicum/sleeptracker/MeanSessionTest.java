package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeanSessionTest {
    @Test
    public void applyOneSession() {
        assertEquals(
                465,
                new MeanSession().apply(List.of(new SleepingSession(LocalDateTime.of(2026, 8, 30, 23, 15),
                        LocalDateTime.of(2026, 8, 31, 7, 0), null))).value
        );
    }

    @Test
    public void applyTwoSession() {
        assertEquals(
                495,
                new MeanSession().apply(
                        List.of(
                                new SleepingSession(
                                        LocalDateTime.of(2026, 8, 30, 23, 15),
                                        LocalDateTime.of(2026, 8, 31, 7, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 8, 30, 22, 15),
                                        LocalDateTime.of(2026, 8, 31, 7, 0),
                                        null
                                )
                        )
                ).value
        );
    }
}
