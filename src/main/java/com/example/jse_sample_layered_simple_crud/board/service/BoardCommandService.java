package com.example.jse_sample_layered_simple_crud.board.service;

import com.example.jse_sample_layered_simple_crud.board.exception.BoardCommandErrorCode;
import com.example.jse_sample_layered_simple_crud.board.repository.BoardQueryRepository;
import com.example.jse_sample_layered_simple_crud.board.repository.projection.BoardProjection.*;
import com.example.jse_sample_layered_simple_crud.board.usecase.BoardSelectOneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardCommandService implements BoardSelectOneUseCase {
    private final BoardQueryRepository boardQueryRepository;
    @Override
    public BoardDetailProjection findById(Long id) {
        return boardQueryRepository.findBoardById(id)
                .orElseThrow(BoardCommandErrorCode.BOARD_NOT_FOUND::defaultException);
    }
}
