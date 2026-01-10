package ru.practicum.stats.dto;

import java.time.format.DateTimeFormatter;

public final class StatsConstants {

    public static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private StatsConstants() {
    }
}
