package com.training.todolist.mapper;
import com.training.todolist.dto.TagRequest;
import com.training.todolist.dto.TagResponse;
import com.training.todolist.dto.TodoRequest;
import com.training.todolist.dto.TodoResponse;
import com.training.todolist.entity.Tag;
import com.training.todolist.entity.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {

    public TagMapper() {
    }

    public Tag toEntity(TagRequest tagRequest) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(tagRequest, tag);

        return tag;
    }

    public TagResponse toResponse(Tag tag) {
        TagResponse tagResponse = new TagResponse();
        BeanUtils.copyProperties(tag, tagResponse);

        return tagResponse;
    }
}
