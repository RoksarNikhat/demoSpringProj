package com.example.demoSpringProj.order;

import com.example.demoSpringProj.product.Product;
import com.example.demoSpringProj.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(value="Product that has been placed on order ")
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;


    @ApiModelProperty(value="User who placed the order ")
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ApiModelProperty(value="Quantity of the product",example="10")
    @Column(name="QUANTITY")
    private Integer quantity;

}
