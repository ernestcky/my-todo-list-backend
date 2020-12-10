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
}
