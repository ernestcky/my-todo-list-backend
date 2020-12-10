package com.training.todolist.services;

import com.training.todolist.entity.Tag;
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

    public Tag findById(String tagId) {
        return this.tagRepository.findById(tagId).orElse(null);
    }

    public Tag update(String tagId, Tag tagUpdate) {
        if (!this.tagRepository.existsById(tagId)) {
            throw new RuntimeException();
        }
        tagUpdate.setTagId(tagId);
        return this.tagRepository.save(tagUpdate);
    }
}
