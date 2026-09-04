package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class MaxSession implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        return new SleepAnalysisResult("Максимальная продолжительность сессии в минутах: ", (int) sleepingSessions.stream()
                .map(sleepingSession -> Duration.between(sleepingSession.start, sleepingSession.finish))
                .max((duration1, duration2) -> duration1.compareTo(duration2))
                .orElse(Duration.ZERO).getSeconds() / 60
        );
    }
}
