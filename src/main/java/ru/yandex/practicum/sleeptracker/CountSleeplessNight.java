package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;
import java.util.function.Function;

public class CountSleeplessNight implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        if (sleepingSessions.isEmpty()) {
            return new SleepAnalysisResult("Количество бессонных ночей равно: ", 0);
        }
        long sleepNight = sleepingSessions.stream().filter(sleepingSession -> {
            boolean dayChanged = !sleepingSession.start.toLocalDate().equals(sleepingSession.finish.toLocalDate());
            boolean crossSix = sleepingSession.start.toLocalTime().isBefore(LocalTime.of(6, 0)) &&
                    sleepingSession.finish.toLocalTime().isAfter(LocalTime.of(5, 59));
            return dayChanged || crossSix;
        }).count();
        LocalDateTime startFirstNight = sleepingSessions.getFirst().start;
        LocalDateTime finishLastNight = sleepingSessions.getLast().finish;
        long allNight = Period.between(startFirstNight.toLocalDate(), finishLastNight.toLocalDate()).getDays();
        if (allNight == 0) allNight++;
        long sleeplessNight = allNight - sleepNight;
        return new SleepAnalysisResult("Количество бессонных ночей равно: ", (int) sleeplessNight);
    }
}
