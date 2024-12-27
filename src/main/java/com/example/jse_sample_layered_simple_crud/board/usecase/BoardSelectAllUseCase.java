package com.example.jse_sample_layered_simple_crud.board.usecase;

import com.example.jse_sample_layered_simple_crud.board.repository.projection.BoardProjection.BoardSummaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSelectAllUseCase {
    Page<BoardSummaryProjection> findGeneralBy(Pageable pageable);
}
