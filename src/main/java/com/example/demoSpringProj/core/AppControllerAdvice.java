package com.example.demoSpringProj.core;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice("com.example.demoSpringProj")
public class AppControllerAdvice implements ResponseBodyAdvice {
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        String errorMessage = exception.getBindingResult().getFieldErrors().stream()
                .map(err ->  err.getDefaultMessage())
                .distinct()
                .collect(Collectors.joining(", "));
        ApiResponse response = new ApiResponse(400,null,errorMessage);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }



        @ExceptionHandler(Exception.class)

        public ResponseEntity<ApiResponse> handleGlobalException(Exception e) {

            ApiResponse response = new ApiResponse(500,null,e.getMessage());

            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public ApiResponse beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return o instanceof ApiResponse? (ApiResponse) o:new ApiResponse (200,o,null);
    }
}
