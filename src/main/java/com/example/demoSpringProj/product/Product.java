package com.example.demoSpringProj.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(value="Name of the product",example="Bluetooth")
    @Column(name="NAME")
    private String name;

    @ApiModelProperty(value="Description of the product",example="Audio Set")
    @Column(name="DESCRIPTION")
    private String description;

    @ApiModelProperty(value="Price of the product",example="50")
    @Column(name="PRICE")
    private Integer price;

    @ApiModelProperty(value="SIZE of the product",example="M")
    @Column(name="SIZE")
    private String size;



}
