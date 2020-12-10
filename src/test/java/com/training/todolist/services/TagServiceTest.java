package com.training.todolist.services;

import com.training.todolist.entity.Tag;
import com.training.todolist.entity.Todo;
import com.training.todolist.repository.TagRepository;
import com.training.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TagServiceTest {
    @InjectMocks
    TagService tagService;

    @Mock
    TagRepository tagRepository;

    @Test
    public void should_return_all_when_get_all_given_repository_and_tags() {
        // given
        List<Tag> expected = Arrays.asList(new Tag(), new Tag());
        when(tagRepository.findAll()).thenReturn(expected);

        // when
        List<Tag> actual = tagService.findAll();

        // then
        assertEquals(expected, actual);
    }

}
