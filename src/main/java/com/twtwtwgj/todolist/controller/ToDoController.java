package com.twtwtwgj.todolist.controller;

import com.twtwtwgj.todolist.entity.ToDo;
import com.twtwtwgj.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todo")
    public List<ToDo> getToDoList(){
        return toDoService.findAll();
    }

    @PostMapping("/todo")
    public ToDo postToDo(@RequestParam("id") int id, @RequestParam("name") String name){
        final ToDo toDo = new ToDo(id, name);

        return toDoService.save(toDo);
    }
}
