package com.greenmuhly.todo.service;

import com.greenmuhly.todo.domain.Todo;
import com.greenmuhly.todo.domain.MemoryTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private MemoryTodoRepository memoryTodoRepository;




    @Override
    public void postTodo(Todo todo) throws Exception {

    }

    @Override
    public void deleteTodo(Long Id) throws Exception {

    }

    @Override
    public Todo findTodoById(Long Id) throws Exception {
        return null;
    }
}
