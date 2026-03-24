package com.teste.teste.service;

import com.teste.teste.dto.PageResponseDTO;
import com.teste.teste.dto.TodoRequestDTO;
import com.teste.teste.dto.TodoResponseDTO;
import com.teste.teste.entity.Todo;
import com.teste.teste.entity.TodoStatus;
import com.teste.teste.exception.TodoNotFoundException;
import com.teste.teste.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public TodoResponseDTO create(TodoRequestDTO dto) {
        Todo todo = new Todo();

        todo.setTaskName(dto.taskName());

        Todo savedTodo = repository.save(todo);

        return toDto(savedTodo);
    }

    public TodoResponseDTO findById(Long id) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));

        return toDto(todo);
    }

    public TodoResponseDTO update(Long id, TodoRequestDTO dto) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));

        todo.setTaskName(dto.taskName());

        Todo savedTodo = repository.save(todo);

        return toDto(savedTodo);
    }

    public PageResponseDTO<TodoResponseDTO> findAll(Pageable pageable) {

        Page<Todo> page = repository.findAll(pageable);

        List<TodoResponseDTO> todos = page
                .stream()
                .map(this::toDto)
                .toList();

        return new PageResponseDTO<>(
                todos,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    public void delete(Long id) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));

        repository.delete(todo);
    }

    private TodoResponseDTO toDto(Todo todo) {
        return new TodoResponseDTO(todo.getId(),
                todo.getTaskName(),
                todo.getStatus(),
                todo.getCreatedAt());
    }
}
