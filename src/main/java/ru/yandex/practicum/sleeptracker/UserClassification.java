package ru.yandex.practicum.sleeptracker;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class UserClassification implements Function<List<SleepingSession>, SleepAnalysisResult> {
    //0-Сова, 1-Жаворонок, 2-Голубь
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        HashMap<Integer, Integer> sumByClassification = new HashMap<>();
        sumByClassification.put(0, 0);
        sumByClassification.put(1, 0);
        sumByClassification.put(2, 0);
        sleepingSessions.stream().map(sleepingSession -> this.classification(sleepingSession)).forEach(
                classification -> {
                    Integer count = sumByClassification.get(classification);
                    sumByClassification.put(classification, count + 1);
                }
        );
        if (sumByClassification.get(0) > sumByClassification.get(1)
                && sumByClassification.get(0) > sumByClassification.get(2)) {
            return new SleepAnalysisResult("Вы сова", 0);
        } else if (sumByClassification.get(1) > sumByClassification.get(0)
                && sumByClassification.get(1) > sumByClassification.get(2)) {
            return new SleepAnalysisResult("Вы жаворонок", 1);
        } else {
            return new SleepAnalysisResult("Вы голубь", 2);
        }
    }

    private int classification(SleepingSession sleepingSession) {
        if (sleepingSession.start.toLocalTime().isAfter(LocalTime.of(23, 0)) &&
                sleepingSession.finish.toLocalTime().isAfter(LocalTime.of(9, 0))) {
            return 0;
        } else if (sleepingSession.start.toLocalTime().isBefore(LocalTime.of(22, 0)) &&
                sleepingSession.finish.toLocalTime().isBefore(LocalTime.of(7, 0))) {
            return 1;
        } else {
            return 2;
        }
    }
}
