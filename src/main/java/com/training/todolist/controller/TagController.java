package com.training.todolist.controller;

import com.training.todolist.entity.Tag;
import com.training.todolist.entity.Todo;
import com.training.todolist.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping
    public List<Tag> getAll() {
        return this.tagService.findAll();
    }

    @PostMapping
    public Tag create(@RequestBody Tag tag) {
        return this.tagService.create(tag);
    }
}
