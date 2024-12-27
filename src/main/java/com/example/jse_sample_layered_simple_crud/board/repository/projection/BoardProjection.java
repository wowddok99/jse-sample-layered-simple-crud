package com.example.jse_sample_layered_simple_crud.board.repository.projection;

import com.example.jse_sample_layered_simple_crud.board.domain.type.BoardStatus;
import lombok.Builder;

import java.time.Instant;

public class BoardProjection {
    // 기존에 구성한 빌더를 기반으로 새로운 객체를 재구성 할 수 있도록 도와주는 속성
    @Builder(toBuilder = true)
    public record BoardSummaryProjection(
            Long id,
            String title,
            BoardStatus status,
            Instant createdAt
    ) {}
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
