package com.training.todolist.controller;

import com.training.todolist.entity.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Todo")
public class TodoController {
    @GetMapping
    public List<Todo> getAll() {
        return null;
    }
}
