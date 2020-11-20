package com.example.demoSpringProj.core;

import org.springframework.util.ObjectUtils;

import java.util.List;

public class ValidationUtils {
    public static void validateProductSize(String size,boolean nullCheck) throws Exception {
        if(nullCheck&& ObjectUtils.isEmpty(size)){
            throw new Exception("Size cannot be empty");
        }
        if (!ObjectUtils.isEmpty(size)&&!size.matches("^[SML]+$")) {
            throw new Exception("Size can only contain S,M or L value");

        }
    }
    public static void validateProductSizes(List<String> sizes) throws Exception {
        if(!ObjectUtils.isEmpty(sizes)){
           for(String size:sizes){
               ValidationUtils.validateProductSize(size,true);
           }

        }

    }
}
