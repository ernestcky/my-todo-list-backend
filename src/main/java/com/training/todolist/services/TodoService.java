package com.training.todolist.services;

import com.training.todolist.entity.Todo;
import com.training.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll() {
        return this.todoRepository.findAll();
    }

    public Todo create(Todo expected) {
        return this.todoRepository.insert(expected);
    }

    public Todo findById(String todoId) {
        return this.todoRepository.findById(todoId).orElse(null);
    }

    public Todo update(String todoId, Todo expected) {
        return null;
    }
}
