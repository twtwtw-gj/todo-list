package com.twtwtwgj.todolist.service;

import com.twtwtwgj.todolist.entity.ToDo;
import com.twtwtwgj.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ToDoServiceImpl implements ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> findAll(){
        return toDoRepository.findAll();
    }

    @Override
    public ToDo save(ToDo toDo){
        return toDoRepository.save(toDo);
    }
}
