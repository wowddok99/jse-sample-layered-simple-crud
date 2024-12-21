package com.example.jse_sample_layered_simple_crud.board.repository.projection;

import com.example.jse_sample_layered_simple_crud.board.domain.type.BoardStatus;
import lombok.Builder;

import java.time.Instant;

public class BoardProjection {
    @Builder
    public record BoardDetailProjection(
            Long id,
            String title,
            String content,
            BoardStatus status,
            Instant createdAt,
            Instant updatedAt
    ) {}
}
