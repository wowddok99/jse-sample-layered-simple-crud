package com.example.jse_sample_layered_simple_crud.board.controller;

import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardCommandDto.BoardCreateRequest;
import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardCommandDto.BoardCreateResponse;
import com.example.jse_sample_layered_simple_crud.board.domain.Board;
import com.example.jse_sample_layered_simple_crud.board.usecase.BoardCreateUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@Validated
public class BoardCommandApi {
    private final BoardCreateUseCase boardCreateUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardCreateResponse create(
            @RequestBody @Valid BoardCreateRequest request
    ) {
        var board = boardCreateUseCase.create(request);

        return BoardCreateResponse.builder()
                .board(board)
                .build();
    }
}
