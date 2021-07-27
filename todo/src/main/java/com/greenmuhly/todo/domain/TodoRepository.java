package com.greenmuhly.todo.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

//@Repository
//@RequiredArgsConstructor
public interface TodoRepository extends JpaRepository<Todo, Long> {

//    private final EntityManager em;
//
//    public void save(Todo todo) {
//        if (todo.getId() == null) {
//            em.persist(todo);
//        } else {
//            em.merge(todo);
//        }
//    }
//
//    public Todo findOne(Long id) {
//        return em.find(Todo.class, id);
//    }
//
//    public List<Todo> findAll() {
//        return em.createQuery("select t from Todo t", Todo.class)
//                .getResultList();
//    }


}
