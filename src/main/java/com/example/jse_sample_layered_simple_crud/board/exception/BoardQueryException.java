package com.example.jse_sample_layered_simple_crud.board.exception;

import com.example.jse_sample_layered_simple_crud.common.jpa.exeption.CustomException;
import com.example.jse_sample_layered_simple_crud.common.jpa.exeption.ErrorCode;

public class BoardQueryException extends CustomException {
    public BoardQueryException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BoardQueryException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
