package com.teste.teste.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        String message,
        int status,
        LocalDateTime timeStamp
) {
}
