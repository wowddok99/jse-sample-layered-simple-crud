package com.example.jse_sample_layered_simple_crud.board.usecase;

import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardCommandDto.BoardCreateRequest;
import com.example.jse_sample_layered_simple_crud.board.domain.Board;

public interface BoardCreateUseCase {
    Board create(Board board);

    Board create(BoardCreateRequest request);
}
