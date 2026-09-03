package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class MinSession implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        return new SleepAnalysisResult("Минимальная продолжительность сессии в минутах: ", (int) sleepingSessions.stream()
                .map(sleepingSession -> Duration.between(sleepingSession.start, sleepingSession.finish))
                .min((a, b) -> a.compareTo(b))
                .orElse(Duration.ZERO).getSeconds() / 60
        );
    }
}
