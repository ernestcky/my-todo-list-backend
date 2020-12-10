package com.training.todolist.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Tag {
    @MongoId(FieldType.OBJECT_ID)
    private String tagId;
    private String content;
    private String color;

    public Tag() {}
}
