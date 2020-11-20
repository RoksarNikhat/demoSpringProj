package com.example.demoSpringProj.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchParams {
    @ApiModelProperty(value="name of the product",example="mobile")
    private String name;

    @ApiModelProperty(value="Description of the product",example="communication media")
    private String description;

    @ApiModelProperty(value="Minimum price of the product",example="10")
    private Integer minPrice;

    @ApiModelProperty(value="Maximum price of the product",example="100")
    private Integer maxPrice;

    @ApiModelProperty(value="List of size of the product",example="['L','M']")
     private List<String> sizes;




}
