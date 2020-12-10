package com.training.todolist.controller;

import com.training.todolist.entity.Tag;
import com.training.todolist.entity.Todo;
import com.training.todolist.exceptions.TagNotFoundException;
import com.training.todolist.exceptions.TodoNotFoundException;
import com.training.todolist.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{tagId}")
    public Tag getTagById(@PathVariable String tagId) throws TagNotFoundException {
        return this.tagService.findById(tagId);
    }

    @PutMapping("/{tadId}")
    public Tag update(@PathVariable String tadId, @RequestBody Tag tagUpdate) throws TagNotFoundException {
        return this.tagService.update(tadId, tagUpdate);
    }

    @DeleteMapping("/{tadId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String tadId) {
        this.tagService.delete(tadId);
    }
}
