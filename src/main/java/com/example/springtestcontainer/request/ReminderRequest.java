package com.example.springtestcontainer.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
public class ReminderRequest {

    @JsonProperty
    private String name;
}
