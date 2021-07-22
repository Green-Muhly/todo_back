package com.greenmuhly.todo.service;

import com.greenmuhly.todo.domain.Todo;
import com.greenmuhly.todo.domain.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;




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
