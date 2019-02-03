package com.example.test.springboottest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data(staticConstructor = "of")
@Getter
public class Payment {

    private final String amount;

}
