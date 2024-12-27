package com.example.jse_sample_layered_simple_crud.board.domain.type;

import com.example.jse_sample_layered_simple_crud.board.repository.projection.BoardProjection.BoardSummaryProjection;

import java.util.EnumSet;
import java.util.Set;

public enum BoardStatus {
    ACTIVE,
    SUSPENDED,
    REMOVED;
}