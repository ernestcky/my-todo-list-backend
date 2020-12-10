package com.training.todolist.integration;

import com.training.todolist.entity.Tag;
import com.training.todolist.entity.Todo;
import com.training.todolist.repository.TagRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TagIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private TagRepository tagRepository;

    @AfterEach
    void tearDown() {
        tagRepository.deleteAll();
    }

    @Test
    public void should_return_all_tag_when_get_all_given_tags() throws Exception {
        //given
        Tag tag = new Tag("Tag1", "green");
        tagRepository.save(tag);

        //when
        //then
        mockMvc.perform(get("/tag"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tagId").isString())
                .andExpect(jsonPath("$[0].content").value("Tag1"))
                .andExpect(jsonPath("$[0].color").value("green"));
    }

    @Test
    public void should_return_tag_when_create_tag_given_tag() throws Exception {
        //given
        String tagAsJson = "{\n" +
                "    \"content\": \"tag1\",\n" +
                "    \"color\": \"blue\"\n" +
                "}";

        //when
        mockMvc.perform(post("/tag")
                .contentType(APPLICATION_JSON)
                .content(tagAsJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tagId").isString())
                .andExpect(jsonPath("$.content").value("tag1"))
                .andExpect(jsonPath("$.color").value("blue"));

        List<Tag> tagList = tagRepository.findAll();
        //the
        assertEquals(1, tagList.size());
        assertEquals("tag1", tagList.get(0).getContent());
        assertEquals("blue", tagList.get(0).getColor());
    }

    @Test
    public void should_return_correct_tag_when_get_tag_given_valid_id() throws Exception {
        //given
        Tag tag = new Tag("Tag1", "blue");
        tagRepository.insert(tag);

        //when
        mockMvc.perform(get("/tag/" + tag.getTagId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tagId").isString())
                .andExpect(jsonPath("$.content").value("Tag1"))
                .andExpect(jsonPath("$.color").value("blue"));
    }

    @Test
    public void should_return_not_found_status_when_get_tag_given_invalid_id() throws Exception {
        //when
        Tag tag = new Tag("Tag1", "blue");
        tagRepository.insert(tag);

        String id = tag.getTagId();

        tagRepository.deleteById(id);

        mockMvc.perform(get("/tag/" + id))
                .andExpect(status().isNotFound());
    }

}
