package com.example.jse_sample_layered_simple_crud.board.controller;

import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardQueryDto.*;
import com.example.jse_sample_layered_simple_crud.board.mapper.BoardDtoMapper;
import com.example.jse_sample_layered_simple_crud.board.usecase.BoardSelectAllUseCase;
import com.example.jse_sample_layered_simple_crud.board.usecase.BoardSelectOneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardQueryApi {
    private final BoardSelectOneUseCase boardSelectOneUseCase;
    private final BoardSelectAllUseCase boardSelectAllUseCase;
    private final BoardDtoMapper mapper;

    @GetMapping("/{id}")
    public BoardSelectOneResponse selectOne(@PathVariable("id") Long id) {
        var board = boardSelectOneUseCase.findById(id);

        return BoardSelectOneResponse.builder()
                .board(board)
                .build();
    }

    @GetMapping
    public BoardSelectAllResponse selectAll(@PageableDefault(size = 8) Pageable pageable) {
        pageable = pageable.previousOrFirst();

        var page = boardSelectAllUseCase.findGeneralBy(pageable);

        return mapper.toResponse(page, pageable.getPageNumber() + 1);
    }

}
