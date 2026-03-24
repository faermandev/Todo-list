package com.teste.teste.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record ValidationErrorResponse(
        String message,
        Map<String, String> errors,
        int status,
        LocalDateTime timestamp
) {}