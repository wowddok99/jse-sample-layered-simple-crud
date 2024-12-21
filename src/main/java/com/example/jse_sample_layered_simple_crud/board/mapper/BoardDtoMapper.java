package com.example.jse_sample_layered_simple_crud.board.mapper;

import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardCommandDto.BoardCreateRequest;
import com.example.jse_sample_layered_simple_crud.board.domain.Board;
import com.example.jse_sample_layered_simple_crud.board.domain.type.BoardStatus;
import org.mapstruct.Mapper;

import java.time.Instant;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface BoardDtoMapper {
    Board toEntity(BoardCreateRequest dto, BoardStatus status, Instant createdAt, Instant updatedAt);
}
