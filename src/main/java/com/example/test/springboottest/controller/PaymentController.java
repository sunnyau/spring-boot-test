package com.example.test.springboottest.controller;

import com.example.test.springboottest.model.Payment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PaymentController {

    @GetMapping(value = "/getPayment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPayment() {
        return ResponseEntity.ok(Payment.of("2.56"));
    }

    @GetMapping(value = "/getPayment/{interest}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Payment getPaymentJson(@PathVariable Integer interest) {
        return Payment.of(interest.toString());
    }

}
