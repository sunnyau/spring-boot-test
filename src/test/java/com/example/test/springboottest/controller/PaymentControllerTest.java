package com.example.test.springboottest.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class PaymentControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private PaymentController paymentController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

    @Test
    public void testGetPayment() throws Exception {
        mockMvc.perform(get("/getPayment"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Payment"));
    }

    @Test
    public void testGetPaymentJson() throws Exception {
        mockMvc.perform(get("/getPaymentJson"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount", Matchers.is("1.23") ));
    }

}