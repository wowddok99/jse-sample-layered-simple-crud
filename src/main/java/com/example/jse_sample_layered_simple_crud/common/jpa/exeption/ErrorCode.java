package com.example.jse_sample_layered_simple_crud.common.jpa.exeption;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String name(); // enum default method
    String defaultMessage();
    HttpStatus defaultHttpStatus();
    RuntimeException defaultException();
    RuntimeException defaultException(Throwable cause);
}
