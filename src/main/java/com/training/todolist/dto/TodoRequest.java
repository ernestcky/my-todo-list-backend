package com.training.todolist.dto;

import com.training.todolist.entity.Tag;

import java.util.List;

public class TodoRequest {
    private String text;
    private Boolean done;
    private List<Tag> tagList;

    public TodoRequest() {}

    public TodoRequest(String text, Boolean done, List<Tag> tagList) {
        this.text = text;
        this.done = done;
        this.tagList = tagList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
