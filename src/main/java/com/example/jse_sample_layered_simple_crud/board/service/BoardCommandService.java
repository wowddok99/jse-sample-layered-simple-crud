package com.example.jse_sample_layered_simple_crud.board.service;

import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardCommandDto.BoardCreateRequest;
import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardCommandDto.BoardUpdateRequest;
import com.example.jse_sample_layered_simple_crud.board.domain.Board;
import com.example.jse_sample_layered_simple_crud.board.domain.type.BoardStatus;
import com.example.jse_sample_layered_simple_crud.board.exception.BoardCommandErrorCode;
import com.example.jse_sample_layered_simple_crud.board.mapper.BoardDtoMapper;
import com.example.jse_sample_layered_simple_crud.board.repository.BoardCommandRepository;
import com.example.jse_sample_layered_simple_crud.board.repository.BoardQueryRepository;
import com.example.jse_sample_layered_simple_crud.board.usecase.BoardCreateUseCase;
import com.example.jse_sample_layered_simple_crud.board.usecase.BoardUpdateUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class BoardCommandService implements BoardCreateUseCase, BoardUpdateUseCase {
    private final BoardCommandRepository boardCommandRepository;
    private final BoardDtoMapper mapper;

    @Override
    public Board create(Board board) {
        return boardCommandRepository.save(board);
    }

    @Override
    public Board create(BoardCreateRequest request) {
        Instant now = Instant.now();

        Board board = mapper.toEntity(request, BoardStatus.ACTIVE, now, now);

        return create(board);
    }

    @Transactional
    @Override
    public Board update(Long id, BoardUpdateRequest request) {
        Board board = findBoardById(id);

        board.prepareUpdate()
                .title(request.title())
                .content(request.content())
                .update();

        return board;
    }

    private Board findBoardById(Long id) {
        Board board = boardCommandRepository
                .findById(id)
                .orElseThrow(BoardCommandErrorCode.BOARD_NOT_FOUND::defaultException);

        if (board.getStatus() == BoardStatus.REMOVED) {
            throw BoardCommandErrorCode.BOARD_GONE.defaultException();
        }

        return board;
    }
}
