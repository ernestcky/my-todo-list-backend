package com.training.todolist.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class Todo {
    @MongoId(FieldType.OBJECT_ID)
    private String todoId;
    private String text;
    private Boolean done;
    private List<Tag> tagList;

    public Todo() {}

    public Todo(String text, Boolean done, List<Tag> tagList) {
        this.text = text;
        this.done = done;
        this.tagList = tagList;
    }

    public Todo(String todoId, String text, Boolean done, List<Tag> tagList) {
        this.todoId = todoId;
        this.text = text;
        this.done = done;
        this.tagList = tagList;
    }

    public String getTodoId() {
        return this.todoId;
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
