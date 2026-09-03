package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSleeplessNightTest {
    @Test
    public void zeroNights() {
        assertEquals(
                0,
                new CountSleeplessNight().apply(
                        List.of(
                        )
                ).value
        );
    }

    @Test
    public void sleeplessNightEq0() {
        assertEquals(
                0,
                new CountSleeplessNight().apply(
                        List.of(
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 1, 23, 0),
                                        LocalDateTime.of(2026, 9, 2, 7, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 3, 0, 0),
                                        LocalDateTime.of(2026, 9, 3, 6, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 4, 5, 59),
                                        LocalDateTime.of(2026, 9, 4, 10, 0),
                                        null
                                )
                        )
                ).value
        );
    }

    @Test
    public void sleeplessNightEq1() {
        assertEquals(
                1,
                new CountSleeplessNight().apply(
                        List.of(
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 1, 23, 0),
                                        LocalDateTime.of(2026, 9, 2, 7, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 3, 0, 0),
                                        LocalDateTime.of(2026, 9, 3, 6, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 5, 5, 59),
                                        LocalDateTime.of(2026, 9, 5, 10, 0),
                                        null
                                )
                        )
                ).value
        );
    }

    @Test
    public void sleeplessNightEq2() {
        assertEquals(
                2,
                new CountSleeplessNight().apply(
                        List.of(
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 1, 23, 0),
                                        LocalDateTime.of(2026, 9, 2, 7, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 3, 0, 0),
                                        LocalDateTime.of(2026, 9, 3, 6, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 5, 5, 59),
                                        LocalDateTime.of(2026, 9, 5, 10, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 5, 23, 59),
                                        LocalDateTime.of(2026, 9, 6, 10, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 7, 11, 59),
                                        LocalDateTime.of(2026, 9, 7, 15, 1),
                                        null
                                )
                        )
                ).value
        );
    }

    @Test
    public void sleeplessNightEq1ForOnlyOneNight() {
        assertEquals(
                1,
                new CountSleeplessNight().apply(
                        List.of(
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 3, 0, 0),
                                        LocalDateTime.of(2026, 9, 3, 5, 0),
                                        null
                                )
                        )
                ).value
        );
    }
}