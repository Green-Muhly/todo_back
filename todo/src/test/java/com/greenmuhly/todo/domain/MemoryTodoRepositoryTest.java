package com.greenmuhly.todo.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemoryTodoRepositoryTest {

    MemoryTodoRepository memoryTodoRepository = new MemoryTodoRepository();

    @AfterEach
    void afterEach() {
        memoryTodoRepository.clearTodoList();
    }

    @Test
    void save() {
        //given
        Todo todo = new Todo(1L,"hello spring",true, LocalDateTime.now());
        //when
        Todo savedTodo = memoryTodoRepository.save(todo);
        //then
        Todo findTodo = memoryTodoRepository.findById(todo.getId());
        assertThat(findTodo).isEqualTo(savedTodo);
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        //given
        Todo todo = new Todo(1L,"hello spring",true, LocalDateTime.now());
        //when
        Todo savedTodo = memoryTodoRepository.save(todo);
        memoryTodoRepository.delete(savedTodo.getId());
        List<Todo> result = memoryTodoRepository.findAll();
        //then
        assertThat(result).doesNotContain(savedTodo);
    }
}