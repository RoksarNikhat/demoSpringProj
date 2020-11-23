package com.example.demoSpringProj.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSearchParams {
    @ApiModelProperty(value="name of the product",example="mobile")
    private String productName;

    @ApiModelProperty(value="name of the product",example="Rahul")
    private String userName;

    @ApiModelProperty(value="Minimum amount of the product",example="100")
    private Integer minAmount;

    @ApiModelProperty(value="Maximum amount of the product",example="1000")
    private Integer maxAmount;


}
