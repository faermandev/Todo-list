package com.teste.teste.dto;

import com.teste.teste.entity.TodoStatus;

import java.time.LocalDateTime;

public record TodoResponseDTO(
        Long id,
        String taskName,
        TodoStatus status,
        LocalDateTime createdAt
) {
}
