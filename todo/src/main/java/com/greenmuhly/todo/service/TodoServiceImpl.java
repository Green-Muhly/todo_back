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
    TodoRepository todoRepository;

    @Override
    public List<Todo> getTodos(Sort sort) throws Exception {
        return todoRepository.findAll(sort);
    }

    @Override
    public void postTodo(Todo todo) throws Exception {
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long id) throws Exception {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo findTodoById(Long id) throws Exception {
        return todoRepository.findById(id).orElse(new Todo());
    }
}
