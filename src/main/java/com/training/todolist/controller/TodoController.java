package com.training.todolist.controller;

import com.training.todolist.dto.TodoRequest;
import com.training.todolist.dto.TodoResponse;
import com.training.todolist.entity.Todo;
import com.training.todolist.exceptions.TodoNotFoundException;
import com.training.todolist.mapper.TodoMapper;
import com.training.todolist.repository.TodoRepository;
import com.training.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Todo")
public class TodoController {
    private TodoService todoService;
    private TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @GetMapping
    public List<TodoResponse> getAll() {
        return this.todoService.findAll().stream().map(todoMapper::toResponse).collect(Collectors.toList());
    }

    @PostMapping
    public TodoResponse create(@RequestBody TodoRequest todoRequest) {
        return todoMapper.toResponse(this.todoService.create(todoMapper.toEntity(todoRequest)));
    }

    @GetMapping("/{todoId}")
    public TodoResponse getTodoById(@PathVariable String todoId) throws TodoNotFoundException {
        return todoMapper.toResponse(this.todoService.findById(todoId));
    }

    @PutMapping("/{todoId}")
    public TodoResponse update(@PathVariable String todoId, @RequestBody TodoRequest todoUpdate) throws TodoNotFoundException {
        return todoMapper.toResponse(this.todoService.update(todoId, todoMapper.toEntity(todoUpdate)));
    }

    @DeleteMapping("/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String todoId) {
        this.todoService.delete(todoId);
    }
}
