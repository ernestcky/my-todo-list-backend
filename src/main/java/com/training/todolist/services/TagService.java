package com.training.todolist.services;

import com.training.todolist.entity.Tag;
import com.training.todolist.exceptions.TagNotFoundException;
import com.training.todolist.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> findAll() {
        return this.tagRepository.findAll();
    }

    public Tag create(Tag tag) {
        return this.tagRepository.insert(tag);
    }

    public Tag findById(String tagId) throws TagNotFoundException {
        return this.tagRepository.findById(tagId).orElseThrow(() -> new TagNotFoundException("Tag Not Found."));
    }

    public Tag update(String tagId, Tag tagUpdate) throws TagNotFoundException {
        if (!this.tagRepository.existsById(tagId)) {
            throw new TagNotFoundException("Tag Not Found.");
        }
        tagUpdate.setTagId(tagId);
        return this.tagRepository.save(tagUpdate);
    }

    public void delete(String tagId) {
        this.tagRepository.deleteById(tagId);
    }
}
