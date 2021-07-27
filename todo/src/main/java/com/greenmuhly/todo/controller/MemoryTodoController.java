package com.greenmuhly.todo.controller;

import com.greenmuhly.todo.domain.Todo;
import com.greenmuhly.todo.domain.MemoryTodoRepository;
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
public class MemoryTodoController {

    private final MemoryTodoRepository memoryTodoRepository;

    @GetMapping
    public String todos(Model model) {
        List<Todo> todos = memoryTodoRepository.findAll();
        model.addAttribute("todos", todos);
        log.info("todoRepository={}", todos);
        return "v1/todos";
    }

    @GetMapping("/{todoId}")
    public String todo(@PathVariable long todoId, Model model) {
        Todo todo = memoryTodoRepository.findById(todoId);
        model.addAttribute("todo", todo);
        return "v1/todo";
    }

    @GetMapping("/add")
    public String addForm() {
        return "v1/addForm";
    }

    @PostMapping("/add")
    public String addTodo(Todo todo, RedirectAttributes redirectAttributes) {
        Todo savedTodo = memoryTodoRepository.save(todo);
        redirectAttributes.addAttribute("todoId", savedTodo.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/v1/todos";
    }

    @GetMapping("/{todoId}/edit")
    public String editForm(@PathVariable Long todoId, Model model) {
        Todo todo = memoryTodoRepository.findById(todoId);
        model.addAttribute("todo", todo);
        return "v1/editForm";
    }

    @PostMapping("/{todoId}/edit")
    public String edit(@PathVariable Long todoId, @ModelAttribute Todo todo) {
        memoryTodoRepository.update(todoId, todo);
        return "redirect:v1/todos/{todoId}";
    }

    @DeleteMapping("/{todoId}")
    public String delete(@PathVariable("id") Long todoId) {
        memoryTodoRepository.delete(todoId);
        return "redirect:v1/todos";
    }


    /**
     * 테스트용 데이터 추가
     */

    @PostConstruct
    public void init() {
        memoryTodoRepository.save(new Todo("hello spring", true));
        memoryTodoRepository.save(new Todo("hello java", false));
    }
}
