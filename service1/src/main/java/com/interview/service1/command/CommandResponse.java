package com.interview.service1.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class CommandResponse {

    private String response;
    private String status;
}
