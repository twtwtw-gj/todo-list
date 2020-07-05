package com.twtwtwgj.todolist.repository;

import com.twtwtwgj.todolist.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
    @Override
    public List<ToDo> findAll();

    @Override
    public ToDo save(ToDo toDo);
}