package com.greenmuhly.todo.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TaskRepository {

    private static final Map<Long, Task> todoList = new HashMap<>();
    private static long sequence = 0L;

    public Task write(Task task) {
        task.setId(++sequence);
        todoList.put(task.getId(), task);
        return task;
    }

    public Task findById(Long id) {
        return todoList.get(id);
    }

    public List<Task> findAll() {
        return new ArrayList<>(todoList.values());
    }

    public void update(Long taskId, Task updateParam) {
        Task findTask = findById(taskId);
        findTask.setTitle(updateParam.getTitle());
        findTask.setContent(updateParam.getContent());
    }

    public void clearTodoList() {
        todoList.clear();
    }

}
