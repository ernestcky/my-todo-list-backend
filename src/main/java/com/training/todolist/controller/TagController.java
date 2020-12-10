package com.training.todolist.controller;

import com.training.todolist.entity.Tag;
import com.training.todolist.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
