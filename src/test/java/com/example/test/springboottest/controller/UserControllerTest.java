package com.example.test.springboottest.controller;

import com.example.test.springboottest.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getAll() throws Exception {

        when(userRepository.findAll()).thenReturn(Collections.emptyList());

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/user/all").accept(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println( mvcResult.getResponse());

        verify(userRepository).findAll();
    }
}