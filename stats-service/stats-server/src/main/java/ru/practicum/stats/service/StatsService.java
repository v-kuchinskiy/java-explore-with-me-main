package ru.practicum.stats.service;

import ru.practicum.stats.dto.EndpointHitDto;
import ru.practicum.stats.dto.ViewStatsDto;

import java.util.List;

public interface StatsService {

    void addHit(EndpointHitDto endpointHitDto);

    List<ViewStatsDto> getStats(String start, String end, List<String> uris, boolean unique);
}
