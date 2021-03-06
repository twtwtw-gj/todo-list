package com.twtwtwgj.todolist.controller;

import com.twtwtwgj.todolist.entity.ToDo;
import com.twtwtwgj.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todo")
    public List<ToDo> getToDoList() {
        return toDoService.findAll();
    }

    @PostMapping("/todo")
    public ToDo postToDo(final @RequestParam("id") int id, final @RequestParam("name") String name) {
        final ToDo toDo = new ToDo(id, name);

        return toDoService.save(toDo);
    }

    @DeleteMapping("/todo")
    public void deleteToDo(final @RequestParam("id") int id) {
        toDoService.delete(id);
    }
}
