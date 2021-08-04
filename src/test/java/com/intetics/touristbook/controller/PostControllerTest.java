package com.intetics.touristbook.controller;

import org.junit.Assert;
import com.intetics.touristbook.service.PostService;
import com.intetics.touristbook.service.dto.PostDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
class PostControllerTest {

    @MockBean
    private PostService service;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPost() throws Exception {
        given(service.getById(1)).willReturn(
                new PostDto(1, new BigDecimal("273.0"),"Belarus",
                        "test", "user","Clear",
                        LocalDate.now()));

        this.mockMvc.perform(get("/posts/1"))
                .andExpect(status().isOk()).
                andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }


    @Test
    void createPost() throws Exception{
        given(service.getById(1)).willReturn(
                new PostDto(1, new BigDecimal("273.0"),"Belarus",
                        "test", "user","Clear",
                        LocalDate.now()));

        this.mockMvc.perform(post("/posts/1"))
                .andExpect(status().isOk()).
                andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void updatePost() throws Exception{
        given(service.getById(1)).willReturn(
                new PostDto(1, new BigDecimal("273.0"),"Belarus",
                        "test", "user","Clear",
                        LocalDate.now()));

        this.mockMvc.perform(put("/posts/1"))
                .andExpect(status().isOk()).
                andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    void deletePost() throws Exception {
        given(service.getById(1)).willReturn(
                new PostDto(1, new BigDecimal("273.0"),"Belarus",
                        "test", "user","Clear",
                        LocalDate.now()));

        this.mockMvc.perform(delete("/posts/1"))
                .andExpect(status().isOk());

    }
}