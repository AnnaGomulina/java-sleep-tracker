package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;

public class SleepingSession {
    LocalDateTime start;
    LocalDateTime finish;
    Estimation estimation;

    public enum Estimation {
        GOOD,
        NORMAL,
        BAD;
    }

    public SleepingSession(LocalDateTime start, LocalDateTime finish, Estimation estimation) {
        this.start = start;
        this.finish = finish;
        this.estimation = estimation;
    }
}
