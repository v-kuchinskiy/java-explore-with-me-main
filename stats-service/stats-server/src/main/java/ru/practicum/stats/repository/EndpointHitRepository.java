package ru.practicum.stats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.practicum.stats.model.EndpointHit;

import java.time.LocalDateTime;
import java.util.List;

public interface EndpointHitRepository extends JpaRepository<EndpointHit, Long> {

    @Query("SELECT h.app AS app, " +
            "       h.uri AS uri, " +
            "       COUNT(h.id) AS hits " +
            "FROM EndpointHit h " +
            "WHERE h.timestamp BETWEEN :start AND :end " +
            "  AND (:urisEmpty = true OR h.uri IN :uris) " +
            "GROUP BY h.app, h.uri " +
            "ORDER BY hits DESC")
    List<ViewStatsProjection> findStats(@Param("start") LocalDateTime start,
                                        @Param("end") LocalDateTime end,
                                        @Param("uris") List<String> uris,
                                        @Param("urisEmpty") boolean urisEmpty);

    @Query("SELECT h.app AS app, " +
            "       h.uri AS uri, " +
            "       COUNT(DISTINCT h.ip) AS hits " +
            "FROM EndpointHit h " +
            "WHERE h.timestamp BETWEEN :start AND :end " +
            "  AND (:urisEmpty = true OR h.uri IN :uris) " +
            "GROUP BY h.app, h.uri " +
            "ORDER BY hits DESC")
    List<ViewStatsProjection> findUniqueStats(@Param("start") LocalDateTime start,
                                              @Param("end") LocalDateTime end,
                                              @Param("uris") List<String> uris,
                                              @Param("urisEmpty") boolean urisEmpty);

    interface ViewStatsProjection {
        String getApp();

        String getUri();

        Long getHits();
    }
}
