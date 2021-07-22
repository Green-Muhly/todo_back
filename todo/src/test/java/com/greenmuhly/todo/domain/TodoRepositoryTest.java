package com.greenmuhly.todo.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TodoRepositoryTest {

    TodoRepository todoRepository = new TodoRepository();

    @AfterEach
    void afterEach() {
        todoRepository.clearTodoList();
    }

    @Test
    void save() {
        //given
        Todo todo = new Todo("todo1", "hello spring");
        //when
        Todo savedTodo = todoRepository.save(todo);
        //then
        Todo findTodo = todoRepository.findById(todo.getId());
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
        Todo todo = new Todo("todo1", "hello spring");
        //when
        Todo savedTodo = todoRepository.save(todo);
        todoRepository.delete(savedTodo.getId());
        List<Todo> result = todoRepository.findAll();
        //then
        assertThat(result).contains(savedTodo);
    }
}