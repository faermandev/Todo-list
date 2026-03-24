package com.teste.teste.repository;

import com.teste.teste.entity.Todo;
import com.teste.teste.entity.TodoStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Page<Todo> findByStatus(TodoStatus status, Pageable pageable);
}
