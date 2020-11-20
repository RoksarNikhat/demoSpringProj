package com.example.demoSpringProj.product;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class ProductDao {
    private NamedParameterJdbcTemplate jdbcTemplate;

    public ProductDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> getProducts(ProductSearchParams params) {
        Map<String,Object> namedParameters=new HashMap<>();
        String sql = "select * from product where 1=1";
        if(!ObjectUtils.isEmpty(params.getName())){
            sql += " and upper(name) like concat('%',upper(:name),'%')";
            namedParameters.put("name",params.getName());

        }
        if(!ObjectUtils.isEmpty(params.getDescription())){
            sql += " and upper(description) like concat('%',upper(:description),'%')";
            namedParameters.put("description",params.getDescription());

        }
        if(!ObjectUtils.isEmpty(params.getMinPrice())){
            sql += " and price >= :minPrice ";
            namedParameters.put("minPrice",params.getMinPrice());

        }
        if(!ObjectUtils.isEmpty(params.getMinPrice())){
            sql += " and price <= :maxPrice ";
            namedParameters.put("maxPrice",params.getMaxPrice());

        }
        if(!ObjectUtils.isEmpty(params.getSizes())){
            sql += " and upper(size) in (:size)";
            namedParameters.put("size",params.getSizes());

        }
        List<Product> products = new ArrayList<>();
         jdbcTemplate.query(sql,namedParameters,rs ->{
           Product  product = new Product();
           product.setId(rs.getLong("ID"));
           product.setName(rs.getString("NAME"));
             product.setDescription(rs.getString("DESCRIPTION"));
             product.setPrice(rs.getInt("PRICE"));
             product.setSize(rs.getString("SIZE"));
             products.add(product);

         });
         return products;


    }
}
