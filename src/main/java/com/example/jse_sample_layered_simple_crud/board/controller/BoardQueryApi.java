package com.example.jse_sample_layered_simple_crud.board.controller;

import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardQueryDto.*;
import com.example.jse_sample_layered_simple_crud.board.usecase.BoardSelectOneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardQueryApi {
    private final BoardSelectOneUseCase boardSelectOneUseCase;

    @GetMapping("/{id}")
    public BoardSelectOneResponse selectOne(@PathVariable("id") Long id) {
        var board = boardSelectOneUseCase.findById(id);

        return BoardSelectOneResponse.builder()
                .board(board)
                .build();
    }

}
