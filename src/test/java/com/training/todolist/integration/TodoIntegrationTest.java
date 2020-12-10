package com.training.todolist.integration;

import com.training.todolist.entity.Tag;
import com.training.todolist.entity.Todo;
import com.training.todolist.repository.TodoRepository;
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
public class TodoIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private TodoRepository todoRepository;

    @AfterEach
    void tearDown() {
        todoRepository.deleteAll();
    }
    @Test
    public void should_return_all_todo_when_get_all_given_todos() throws Exception {
        //given
        Todo todo = new Todo("Todo1", false, Arrays.asList(new Tag("tag1", "blue")));
        todoRepository.save(todo);

        //when
        //then
        mockMvc.perform(get("/Todo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].todoId").isString())
                .andExpect(jsonPath("$[0].text").value("Todo1"))
                .andExpect(jsonPath("$[0].done").value(false))
                .andExpect(jsonPath("$[0].tagList[0].content").value("tag1"))
                .andExpect(jsonPath("$[0].tagList[0].color").value("blue"));
    }
}
