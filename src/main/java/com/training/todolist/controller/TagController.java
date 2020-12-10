package com.training.todolist.controller;

import com.training.todolist.dto.TagRequest;
import com.training.todolist.dto.TagResponse;
import com.training.todolist.entity.Tag;
import com.training.todolist.entity.Todo;
import com.training.todolist.exceptions.TagNotFoundException;
import com.training.todolist.exceptions.TodoNotFoundException;
import com.training.todolist.mapper.TagMapper;
import com.training.todolist.mapper.TodoMapper;
import com.training.todolist.services.TagService;
import com.training.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TagController {
    private TagService tagService;
    private TagMapper tagMapper;

    public TagController(TagService tagService, TagMapper tagMapper) {
        this.tagService = tagService;
        this.tagMapper = tagMapper;
    }

    @GetMapping
    public List<Tag> getAll() {
        return this.tagService.findAll();
    }

    @PostMapping
    public TagResponse create(@RequestBody TagRequest tag) {
        return tagMapper.toResponse(this.tagService.create(tagMapper.toEntity(tag)));
    }

    @GetMapping("/{tagId}")
    public TagResponse getTagById(@PathVariable String tagId) throws TagNotFoundException {
        return tagMapper.toResponse(this.tagService.findById(tagId));
    }

    @PutMapping("/{tadId}")
    public TagResponse update(@PathVariable String tadId, @RequestBody TagRequest tagUpdate) throws TagNotFoundException {
        return tagMapper.toResponse(this.tagService.update(tadId, tagMapper.toEntity(tagUpdate)));
    }

    @DeleteMapping("/{tadId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String tadId) throws TagNotFoundException {
        this.tagService.delete(tadId);
    }
}
