package com.training.todolist.dto;

import com.training.todolist.entity.Tag;

import java.util.List;

public class TagResponse {
    private String tagId;
    private String content;
    private String color;

    public TagResponse() {
    }

    public TagResponse(String tagId, String content, String color) {
        this.tagId = tagId;
        this.content = content;
        this.color = color;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
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
