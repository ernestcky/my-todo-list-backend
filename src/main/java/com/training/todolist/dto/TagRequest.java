package com.training.todolist.dto;

import com.training.todolist.entity.Tag;

import java.util.List;

public class TagRequest {
    private String content;
    private String color;

    public TagRequest() {}

    public TagRequest(String content, String color) {
        this.content = content;
        this.color = color;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
