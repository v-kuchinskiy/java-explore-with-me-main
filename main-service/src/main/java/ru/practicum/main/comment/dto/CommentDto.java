package ru.practicum.main.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.main.comment.model.CommentStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;

    private String text;

    private Long authorId;

    private Long eventId;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private CommentStatus status;
}
