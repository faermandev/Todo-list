package com.teste.teste.controller;

import com.teste.teste.dto.PageResponseDTO;
import com.teste.teste.dto.TodoRequestDTO;
import com.teste.teste.dto.TodoResponseDTO;
import com.teste.teste.entity.TodoStatus;
import com.teste.teste.service.TodoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoController {

    private final TodoService service;

    @PostMapping
    public TodoResponseDTO create(@Valid @RequestBody TodoRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public TodoResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public PageResponseDTO<TodoResponseDTO> findAll(@RequestParam(required = false) TodoStatus status, Pageable pageable) {
        return service.findAll(status, pageable);
    }

    @PutMapping("/{id}")
    public TodoResponseDTO update(@PathVariable Long id, @Valid @RequestBody TodoRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
