package com.greenmuhly.todo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MemoryTodoRepository {

    private static final Map<Long, Todo> todoList = new HashMap<>();
    private static long sequence = 0L;

    public Todo save(Todo todo) {
        todo.setId(++sequence);
        todo.setCreateDate(LocalDateTime.now());
        todoList.put(todo.getId(), todo);
        return todo;
    }

    public Todo findById(Long id) {
        return todoList.get(id);
    }

    public List<Todo> findAll() {
        return new ArrayList<>(todoList.values());
    }

    public void update(Long todoId, Todo updateParam) {
        Todo findTodo = findById(todoId);
        findTodo.setContent(updateParam.getContent());
    }

    public void delete(Long todoId) {
        todoList.remove(todoId);
    }

    public void clearTodoList() {
        todoList.clear();
    }

}
