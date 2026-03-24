package com.teste.teste.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TodoRequestDTO(
        @NotBlank(message = "Task cannot be empty")
        @Size(min = 3, message = "Task have at least 3 characters")
        String taskName
) {
}
