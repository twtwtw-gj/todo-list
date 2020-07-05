package com.twtwtwgj.todolist.controller;

import com.twtwtwgj.todolist.entity.ToDo;
import com.twtwtwgj.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/todo")
    public List<ToDo> getToDoList(){
        return toDoRepository.findAll();
    }

    @PostMapping("/todo")
    public ToDo postToDo(@RequestParam("id") int id, @RequestParam("name") String name){
        final ToDo toDo = new ToDo(id, name);

        return toDoRepository.save(toDo);
    }
}
