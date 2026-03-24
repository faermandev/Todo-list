package com.teste.teste.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String taskName;

    @Enumerated(EnumType.STRING)
    private TodoStatus status = TodoStatus.NOT_DONE;
    private LocalDateTime createdAt = LocalDateTime.now();
}
