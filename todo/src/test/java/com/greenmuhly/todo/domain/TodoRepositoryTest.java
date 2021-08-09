package com.greenmuhly.todo.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@Transactional
public class TodoRepositoryTest {

    private final String content = "content";

    @Autowired TodoRepository todoRepository;
    @Autowired TestEntityManager em;

    private Todo getSaved(){
        Todo todo = Todo.builder()
                .content(content)
                .createDate(ZonedDateTime.now(ZoneId.of("Asia/Seoul")))
                .build();
        return em.persist(todo);
    }

    @Test
    public void getTest() throws Exception {
        //given
        Todo todo = getSaved();
        System.out.println("==================================");
        System.out.println("todo.getId() = " + todo.getId());
        System.out.println("todo.getContent() = " + todo.getContent());
        System.out.println("todo.getChecked() = " + todo.getChecked());
        System.out.println("todo.getCreateDate() = " + todo.getCreateDate());
        System.out.println("==================================");
        em.persist(todo);
        Long id = todo.getId();

        //when
        Todo savedTodo = todoRepository.getById(id);

        //then
        assertThat(savedTodo.getContent()).isEqualTo(content);
        assertThat(savedTodo.getContent()).isEqualTo(todo.getContent());

    }

    @Test
    public void deleteTest(){
        //given
        Todo todo = getSaved();
        Long id = todo.getId();
        //when
        todoRepository.deleteById(id);

        //then
        assertThat(em.find(Todo.class, id)).isNull();
    }
}
