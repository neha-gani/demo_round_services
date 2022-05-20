package com.interview.service1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {

    private String errorCode;
    private String errorMessage;
    private T data;

    public ResponseDTO(T data)
    {
        this.data = data;
    }
}
