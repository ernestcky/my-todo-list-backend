package com.training.todolist.services;


import com.training.todolist.entity.Tag;
import com.training.todolist.entity.Todo;
import com.training.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {
    @InjectMocks
    TodoService todoService;

    @Mock
    TodoRepository todoRepository;

    @Test
    public void should_return_all_when_get_all_given_repository_and_todos() {
        // given
        List<Todo> expected = Arrays.asList(new Todo(), new Todo());
        when(todoRepository.findAll()).thenReturn(expected);

        // when
        List<Todo> actual = todoService.findAll();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_created_todo_when_create_given_an_empty_repository_and_todo_request() {
        // given
        Todo expected = new Todo();
        when(todoRepository.insert(expected)).thenReturn(expected);

        // when
        Todo actual = todoService.create(expected);

        //given
        assertEquals(expected, actual);

    }

    @Test
    public void should_return_correct_todo_when_get_by_id_given_todo() {
        //given
        Todo expected = new Todo();
        todoRepository.insert(expected);
        when(todoRepository.findById(expected.getTodoId())).thenReturn(Optional.of(expected));
                
        //when
        Todo actual = todoService.findById(expected.getTodoId());
        
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_correct_updated_todo_when_update_given_repository_and_todo() {
        //given
        Todo init = new Todo();
        Todo expected = new Todo("text", true, new ArrayList<Tag>());

        todoRepository.insert(init);

        when(todoRepository.existsById(init.getTodoId())).thenReturn(true);
        when(todoRepository.save(expected)).thenReturn(expected);

        //when
        Todo actual = todoService.update(init.getTodoId(), expected);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void should_delete_successfully_when_delete_given_repository_and_todo_list() {
        //given
        Todo todo = new Todo();
        todoRepository.insert(todo);

        //when
        todoService.delete(todo.getTodoId());

        //then
        verify(todoRepository, times(1)).deleteById(todo.getTodoId());
    }
    

    
}
