package com.training.todolist.dto;

import com.training.todolist.entity.Tag;

import java.util.List;

public class TodoResponse {
    private String todoId;
    private String text;
    private Boolean done;
    private List<Tag> tagList;

    public TodoResponse() {
    }

    public TodoResponse(String text, Boolean done, List<Tag> tagList) {
        this.text = text;
        this.done = done;
        this.tagList = tagList;
    }

    public TodoResponse(String todoId, String text, Boolean done, List<Tag> tagList) {
        this.todoId = todoId;
        this.text = text;
        this.done = done;
        this.tagList = tagList;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
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
