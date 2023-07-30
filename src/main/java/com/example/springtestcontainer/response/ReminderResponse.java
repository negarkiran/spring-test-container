package com.example.springtestcontainer.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReminderResponse {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;
}
