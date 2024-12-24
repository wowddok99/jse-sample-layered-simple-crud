package com.example.jse_sample_layered_simple_crud.board.usecase;

import com.example.jse_sample_layered_simple_crud.board.repository.projection.BoardProjection.*;

public interface BoardSelectOneUseCase {
    BoardDetailProjection findById(Long id);
}
