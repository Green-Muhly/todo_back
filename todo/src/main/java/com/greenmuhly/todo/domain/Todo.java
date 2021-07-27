package com.greenmuhly.todo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String content;
    private Boolean checked;
    private LocalDateTime createDate;

    private LocalDateTime uploadDate;

    @Builder
    public Todo(Long id, String content, Boolean checked, LocalDateTime createDate) {
        this.id = id;
        this.content = content;
        this.checked = checked;
        this.createDate = createDate;
    }
}
