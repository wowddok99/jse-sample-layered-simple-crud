package com.example.jse_sample_layered_simple_crud.board.controller.dto;

import com.example.jse_sample_layered_simple_crud.board.repository.projection.BoardProjection.*;
import lombok.Builder;

public final class BoardQueryDto {
    private BoardQueryDto() {}

    @Builder
    public record BoardSelectOneResponse(
            BoardDetailProjection board
    ) {}
}
