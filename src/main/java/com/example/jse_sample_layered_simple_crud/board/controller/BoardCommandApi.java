package com.example.jse_sample_layered_simple_crud.board.controller;

import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardCommandDto.BoardCreateRequest;
import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardCommandDto.BoardCreateResponse;
import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardCommandDto.BoardUpdateRequest;
import com.example.jse_sample_layered_simple_crud.board.controller.dto.BoardCommandDto.BoardUpdateResponse;
import com.example.jse_sample_layered_simple_crud.board.domain.Board;
import com.example.jse_sample_layered_simple_crud.board.usecase.BoardCreateUseCase;
import com.example.jse_sample_layered_simple_crud.board.usecase.BoardUpdateUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    private final BoardUpdateUseCase boardUpdateUseCase;

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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BoardUpdateResponse update(
            @PathVariable("id")
            @NotNull(message = "글 번호가 지정되지 않았습니다. 오류가 반복되면 고객센터에 문의하세요.")
            Long id,
            @RequestBody @Valid BoardUpdateRequest request
    ) {
        var board = boardUpdateUseCase.update(id, request);

        return BoardUpdateResponse.builder()
                .board(board)
                .build();
    }
}
