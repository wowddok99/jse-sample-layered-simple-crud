package com.example.jse_sample_layered_simple_crud.board.usecase;

import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardCommandDto.BoardUpdateRequest;
import com.example.jse_sample_layered_simple_crud.board.domain.Board;

public interface BoardUpdateUseCase {
    Board update(Long id, BoardUpdateRequest request);
}
