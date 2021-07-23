package com.greenmuhly.todo.controller;

import com.greenmuhly.todo.domain.Todo;
import com.greenmuhly.todo.domain.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;

    @GetMapping
    public String todos(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        log.info("todoRepository={}", todos);
        return "v1/todos";
    }

    @GetMapping("/{todoId}")
    public String todo(@PathVariable long todoId, Model model) {
        Todo todo = todoRepository.findById(todoId);
        model.addAttribute("todo", todo);
        return "v1/todo";
    }

    @GetMapping("/add")
    public String addForm() {
        return "v1/addForm";
    }

    @PostMapping("/add")
    public String addTodo(Todo todo, RedirectAttributes redirectAttributes) {
        Todo savedTodo = todoRepository.save(todo);
        redirectAttributes.addAttribute("todoId", savedTodo.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/v1/todos";
    }

    @GetMapping("/{todoId}/edit")
    public String editForm(@PathVariable Long todoId, Model model) {
        Todo todo = todoRepository.findById(todoId);
        model.addAttribute("todo", todo);
        return "v1/editForm";
    }

    @PostMapping("/{todoId}/edit")
    public String edit(@PathVariable Long todoId, @ModelAttribute Todo todo) {
        todoRepository.update(todoId, todo);
        return "redirect:v1/todos/{todoId}";
    }

    /**
     * 테스트용 데이터 추가
     */

    @PostConstruct
    public void init() {
        todoRepository.save(new Todo("hello spring", true));
        todoRepository.save(new Todo("hello java", false));
    }
}
