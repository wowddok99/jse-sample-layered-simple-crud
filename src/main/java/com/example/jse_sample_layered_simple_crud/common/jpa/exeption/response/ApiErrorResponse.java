package com.example.jse_sample_layered_simple_crud.common.jpa.exeption.response;

import lombok.Builder;

@Builder
public record ApiErrorResponse(
        int status,
        String code,
        String message
) {}
