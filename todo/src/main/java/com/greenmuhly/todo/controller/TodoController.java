package com.greenmuhly.todo.controller;

import com.greenmuhly.todo.domain.Todo;
import com.greenmuhly.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/muhly/todos")
@CrossOrigin(origins = "http://localhost:5000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTodos() throws Exception {
        List<Todo> todos = todoService.getTodos(Sort.by(Sort.Direction.ASC, "id"));
        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<String> postTodo(@RequestBody Todo todo) throws Exception {
        todo.setCreateDate(LocalDateTime.now());
        todo.setChecked(false);
        todoService.postTodo(todo);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putTodo(@PathVariable("id") Long id) throws Exception {
        Todo todo = todoService.findTodoById(id);

        boolean check = todo.getChecked() ? false : true;
        todo.setChecked(check);
        todoService.postTodo(todo);

        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) throws Exception {
        todoService.deleteTodo(id);

        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }
}
