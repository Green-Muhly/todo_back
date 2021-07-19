package com.greenmuhly.todo.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {

    private Long id;
    private String title;
    private String content;
    private Boolean checked;
    private LocalDateTime create_date;
    private LocalDateTime upload_date;

    public Task(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
