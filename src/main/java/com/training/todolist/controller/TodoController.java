package com.training.todolist.controller;

import com.training.todolist.entity.Todo;
import com.training.todolist.repository.TodoRepository;
import com.training.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAll() {
        return this.todoService.findAll();
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return this.todoService.create(todo);
    }

    @GetMapping("/{todoId}")
    public Todo getTodoById(@PathVariable String todoId) {
        return this.todoService.findById(todoId);
    }
}
