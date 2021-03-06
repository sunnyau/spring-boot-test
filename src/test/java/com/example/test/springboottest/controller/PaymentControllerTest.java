package com.example.test.springboottest.controller;

import static com.atlassian.oai.validator.mockmvc.OpenApiValidationMatchers.openApi;
import com.example.test.springboottest.model.Payment;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentControllerTest {

    private static String OPEN_API_DEFINITION = "../docs/openapi.yml";
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @InjectMocks
    private PaymentController paymentController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetPayment() throws Exception {
        mockMvc.perform(get("/getPayment"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Payment.of("2.56"))));
                //.andExpect(openApi().isValid(OPEN_API_DEFINITION));
    }

    @Test
    public void testGetPaymentUserName() throws Exception {
        mockMvc.perform(get("/getPayment/56"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount", Matchers.is("56") ));
                //.andExpect(openApi().isValid(OPEN_API_DEFINITION));
    }

}