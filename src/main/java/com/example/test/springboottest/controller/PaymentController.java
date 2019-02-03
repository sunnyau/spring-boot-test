package com.example.test.springboottest.controller;

import com.example.test.springboottest.model.Payment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PaymentController {

    @GetMapping("/getPayment")
    public String getPayment() {
        return "Hello Payment";
    }

    @GetMapping(value = "/getPaymentJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Payment getPaymentJson() {
        return Payment.of("1.23");
    }

}
