package ru.yandex.practicum.sleeptracker;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SleepTrackerApp {

    public static void main(String[] args) {
        List<SleepingSession> sleepingSession = parseLog(args[0]);
        List<Function<List<SleepingSession>, SleepAnalysisResult>> functions = List.of(new CountSession());
        functions.stream()
                .map(function -> function.apply(sleepingSession))
                .forEach(sleepAnalysisResult -> System.out.println(sleepAnalysisResult.text + sleepAnalysisResult.value));
    }

    private static List<SleepingSession> parseLog(String fileName) {
        try (FileReader fileReader = new FileReader(fileName)) {

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> sleepingSessionInStrings = bufferedReader.lines().toList();
            return sleepingSessionInStrings.stream()
                    .map(sleepingSessionInString -> new SleepingSession(
                            LocalDateTime.parse(sleepingSessionInString.split(";")[0]),
                            LocalDateTime.parse(sleepingSessionInString.split(";")[1]),
                            SleepingSession.Estimation.valueOf(sleepingSessionInString.split(";")[2])
                    )).toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}