package com.example.demoSpringProj.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ApiResponse<T> {

    private Integer code;
    private T data;
    private String message;


}
