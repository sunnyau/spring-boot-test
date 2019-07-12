package com.example.test.springboottest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;

@Data(staticConstructor = "of")
@Getter
public class Payment {

    @JsonFormat
    private final String amount;

}
