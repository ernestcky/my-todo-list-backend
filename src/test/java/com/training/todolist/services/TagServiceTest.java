package com.training.todolist.services;

import com.training.todolist.entity.Tag;
import com.training.todolist.entity.Todo;
import com.training.todolist.exceptions.TagNotFoundException;
import com.training.todolist.repository.TagRepository;
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

    @Test
    public void should_return_created_tag_when_create_given_tag() {
        // given
        Tag expected = new Tag();
        when(tagRepository.insert(expected)).thenReturn(expected);

        // when
        Tag actual = tagService.create(expected);

        //given
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_correct_tag_when_get_by_id_given_tag() throws TagNotFoundException {
        //given
        Tag expected = new Tag();
        tagRepository.insert(expected);
        when(tagRepository.findById(expected.getTagId())).thenReturn(Optional.of(expected));

        //when
        Tag actual = tagService.findById(expected.getTagId());

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_correct_updated_tag_when_update_given_repository_and_tag() throws TagNotFoundException {
        //given
        Tag init = new Tag();
        Tag expected = new Tag("Tag1", "blue");

        tagRepository.insert(init);

        when(tagRepository.existsById(init.getTagId())).thenReturn(true);
        when(tagRepository.save(expected)).thenReturn(expected);

        //when
        Tag actual = tagService.update(init.getTagId(), expected);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void should_delete_successfully_when_delete_given_repository_and_tag_list() {
        //given
        Tag tag = new Tag();
        tagRepository.insert(tag);

        //when
        tagService.delete(tag.getTagId());

        //then
        verify(tagRepository, times(1)).deleteById(tag.getTagId());
    }

}
