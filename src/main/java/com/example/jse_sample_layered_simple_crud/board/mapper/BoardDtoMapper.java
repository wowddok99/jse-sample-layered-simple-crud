package com.example.jse_sample_layered_simple_crud.board.mapper;

import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardCommandDto.BoardCreateRequest;
import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardQueryDto.BoardSelectAllResponse;
import com.example.jse_sample_layered_simple_crud.board.domain.Board;
import com.example.jse_sample_layered_simple_crud.board.domain.type.BoardStatus;
import com.example.jse_sample_layered_simple_crud.board.repository.projection.BoardProjection.BoardSummaryProjection;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.time.Instant;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface BoardDtoMapper {
    Board toEntity(BoardCreateRequest dto, BoardStatus status, Instant createdAt, Instant updatedAt);

    default BoardSelectAllResponse toResponse(Page<BoardSummaryProjection> boards, int currentPage) {
        return BoardSelectAllResponse.builder()
                .boards(boards.stream().toList())
                .page(currentPage)
                .total(boards.getTotalElements())
                .lastPage(boards.getTotalPages())
                .build();
    }
}
