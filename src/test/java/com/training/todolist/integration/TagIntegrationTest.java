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

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
}
