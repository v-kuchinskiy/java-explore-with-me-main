package ru.practicum.main.event.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.main.category.dto.CategoryDto;
import ru.practicum.main.user.dto.UserShortDto;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventShortDto {

    private String annotation;

    private CategoryDto category;

    private long confirmedRequests;

    private LocalDateTime eventDate;

    private Long id;

    private UserShortDto initiator;

    private boolean paid;

    private String title;

    private long views;
}
