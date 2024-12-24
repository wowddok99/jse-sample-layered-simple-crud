package com.example.jse_sample_layered_simple_crud.board.exception;

import com.example.jse_sample_layered_simple_crud.common.jpa.exeption.CustomException;
import com.example.jse_sample_layered_simple_crud.common.jpa.exeption.ErrorCode;

public class BoardCommandException extends CustomException {
    // (intellij) Ctrl + O
    // (eclipse or sts) Alt Shift S => generate constructors

    public BoardCommandException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BoardCommandException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
