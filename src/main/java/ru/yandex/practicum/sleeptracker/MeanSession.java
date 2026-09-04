package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class MeanSession implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        int sum = (int) sleepingSessions.stream()
                .map(sleepingSession -> Duration.between(sleepingSession.start, sleepingSession.finish))
                .reduce((a, b) -> a.plus(b))
                .orElse(Duration.ZERO).getSeconds() / 60;
        int count = new CountSession().apply(sleepingSessions).value;
        return new SleepAnalysisResult("Средняя продолжительность сессии в минутах: ", sum / count);
    }
}
