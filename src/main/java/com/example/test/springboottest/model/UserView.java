package com.example.test.springboottest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserView {

    @JsonFormat
    private final Integer id;
    @JsonFormat
    private final String name;
    @JsonFormat
    private final String title;
}
