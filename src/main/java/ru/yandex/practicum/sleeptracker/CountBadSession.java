package ru.yandex.practicum.sleeptracker;

import java.util.List;
import java.util.function.Function;

public class CountBadSession implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        return new SleepAnalysisResult("Количество сессий с плохим качеством сна равно: ", (int) sleepingSessions.stream()
                .filter(sleepingSession -> sleepingSession.estimation == SleepingSession.Estimation.BAD)
                .count());
    }
}
