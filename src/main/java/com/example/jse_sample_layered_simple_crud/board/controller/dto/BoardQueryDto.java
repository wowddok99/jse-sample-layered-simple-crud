package com.example.jse_sample_layered_simple_crud.board.controller.dto;

import com.example.jse_sample_layered_simple_crud.board.repository.projection.BoardProjection.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;

import java.util.List;

public final class BoardQueryDto {
    private BoardQueryDto() {}

    @Builder
    public record BoardSelectOneResponse(
            BoardDetailProjection board
    ) {}

    @Builder
    public record BoardSelectAllResponse(
            List<BoardSummaryProjection> boards,
            @JsonInclude(Include.NON_NULL)
            Integer page,
            @JsonInclude(Include.NON_NULL)
            Long total,
            @JsonInclude(Include.NON_NULL)
            Integer lastPage
    ) {}
}
