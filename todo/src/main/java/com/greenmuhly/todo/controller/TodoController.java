package com.greenmuhly.todo.controller;

import com.greenmuhly.todo.domain.Task;
import com.greenmuhly.todo.domain.TaskRepository;
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

    private final TaskRepository taskRepository;

    @GetMapping
    public String tasks(Model model) {
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "v1/todos";
    }

    @GetMapping("/{taskId}")
    public String task(@PathVariable long taskId, Model model) {
        Task task = taskRepository.findById(taskId);
        model.addAttribute("task", task);
        return "v1/todo";
    }

    @GetMapping("/add")
    public String addForm() {
        return "v1/addForm";
    }

    @PostMapping("/add")
    public String addTask(Task task, RedirectAttributes redirectAttributes) {
        Task savedTask = taskRepository.save(task);
        redirectAttributes.addAttribute("taskId", savedTask);
        redirectAttributes.addAttribute("status", true);
        return "redirect:/v1/todos/{taskId}";
    }

    @GetMapping("/{taskId}/edit")
    public String editForm(@PathVariable Long taskId, Model model) {
        Task task = taskRepository.findById(taskId);
        model.addAttribute("task", task);
        return "v1/editForm";
    }

    @PostMapping("/{taskId}/edit")
    public String edit(@PathVariable Long taskId, @ModelAttribute Task task) {
        taskRepository.update(taskId, task);
        return "redirect:v1/todos/{taskId}";
    }

    /**
     * 테스트용 데이터 추가
     */

    @PostConstruct
    public void init() {
        taskRepository.save(new Task("taskA", "hello spring"));
        taskRepository.save(new Task("taskB", "hello java"));
    }
}
