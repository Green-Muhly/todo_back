package com.greenmuhly.todo.service;

import com.greenmuhly.todo.domain.Todo;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TodoService {

    void postTodo(Todo todo) throws Exception;

    void deleteTodo(Long Id) throws Exception;

    Todo findTodoById(Long Id) throws Exception;
}
