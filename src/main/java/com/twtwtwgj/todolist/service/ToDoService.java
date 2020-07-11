package com.twtwtwgj.todolist.service;

import com.twtwtwgj.todolist.entity.ToDo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoService {
    public List<ToDo> findAll();

    public ToDo save(ToDo toDo);

    public void delete(int id);
}
