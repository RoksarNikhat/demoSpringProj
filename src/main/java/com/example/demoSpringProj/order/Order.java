package com.example.demoSpringProj.order;

import com.example.demoSpringProj.product.Product;
import com.example.demoSpringProj.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

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


    @ApiModelProperty(value="Last updated timestamp of the order",example="2020-11-20 12:05:00")
    @Column(name="LST_UPD_TS")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedTimestamp;

    @ApiModelProperty(value="Total amount spend on the product",example="1000")
    public Integer getTotalAmount(){
        return ObjectUtils.isEmpty(product)||ObjectUtils.isEmpty(product.getPrice())||ObjectUtils.isEmpty(quantity) ? null: product.getPrice()*quantity;
    }

}
