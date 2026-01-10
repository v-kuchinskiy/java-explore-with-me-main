package ru.practicum.main.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.practicum.main.request.enums.RequestCount;
import ru.practicum.main.request.enums.RequestStatus;
import ru.practicum.main.request.model.ParticipationRequest;

import java.util.List;
import java.util.Optional;

public interface ParticipationRequestRepository extends JpaRepository<ParticipationRequest, Long> {

    List<ParticipationRequest> findByRequesterId(Long requesterId);

    List<ParticipationRequest> findByEventId(Long eventId);

    List<ParticipationRequest> findByEventIdAndStatus(Long eventId, RequestStatus status);

    Optional<ParticipationRequest> findByIdAndRequesterId(Long id, Long requesterId);

    boolean existsByRequesterIdAndEventId(Long requesterId, Long eventId);

    long countByEventIdAndStatus(Long eventId, RequestStatus status);

    @Query("SELECT r.event.id AS eventId, " +
            "       COUNT(r.id) AS total " +
            "FROM ParticipationRequest r " +
            "WHERE r.event.id IN :eventIds " +
            "  AND r.status = :status " +
            "GROUP BY r.event.id")
    List<RequestCount> countByEventIdsAndStatus(@Param("eventIds") List<Long> eventIds,
                                                @Param("status") RequestStatus status);
}
