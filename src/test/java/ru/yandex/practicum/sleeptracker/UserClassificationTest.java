package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserClassificationTest {
    @Test
    public void pigeon() {
        assertEquals(
                2,
                new UserClassification().apply(
                        List.of(
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 1, 23, 0),
                                        LocalDateTime.of(2026, 9, 2, 7, 0),
                                        null
                                )
                        )
                ).value
        );
    }

    @Test
    public void owl() {
        assertEquals(
                0,
                new UserClassification().apply(
                        List.of(
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 1, 23, 30),
                                        LocalDateTime.of(2026, 9, 2, 10, 0),
                                        null
                                )
                        )
                ).value
        );
    }

    @Test
    public void lark() {
        assertEquals(
                1,
                new UserClassification().apply(
                        List.of(
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 1, 21, 59),
                                        LocalDateTime.of(2026, 9, 2, 6, 0),
                                        null
                                )
                        )
                ).value
        );
    }

    @Test
    public void maxLark() {
        assertEquals(
                1,
                new UserClassification().apply(
                        List.of(
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 1, 21, 59),
                                        LocalDateTime.of(2026, 9, 2, 6, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 3, 21, 0),
                                        LocalDateTime.of(2026, 9, 4, 5, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 5, 23, 59),
                                        LocalDateTime.of(2026, 9, 6, 11, 0),
                                        null
                                )
                        )

                ).value
        );
    }

    @Test
    public void maxPigeon() {
        assertEquals(
                2,
                new UserClassification().apply(
                        List.of(
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 1, 21, 59),
                                        LocalDateTime.of(2026, 9, 2, 6, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 3, 21, 0),
                                        LocalDateTime.of(2026, 9, 4, 5, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 5, 23, 59),
                                        LocalDateTime.of(2026, 9, 6, 11, 0),
                                        null
                                ),
                                new SleepingSession(
                                        LocalDateTime.of(2026, 9, 7, 23, 30),
                                        LocalDateTime.of(2026, 9, 8, 12, 0),
                                        null
                                )
                        )

                ).value
        );
    }
}