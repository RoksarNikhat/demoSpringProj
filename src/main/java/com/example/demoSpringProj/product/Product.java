package com.example.demoSpringProj.product;

import com.example.demoSpringProj.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();

    public Product(Long id, String name, String description, Integer price, String size) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
    }



}
