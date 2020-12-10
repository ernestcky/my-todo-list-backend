package com.training.todolist.mapper;
import com.training.todolist.dto.TodoRequest;
import com.training.todolist.dto.TodoResponse;
import com.training.todolist.entity.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public TodoMapper() {
    }

    public Todo toEntity(TodoRequest todoRequest) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoRequest, todo);

        return todo;
    }

    public TodoResponse toResponse(Todo todo) {
        TodoResponse todoResponse = new TodoResponse();
        BeanUtils.copyProperties(todo, todoResponse);

        return todoResponse;
    }
}
