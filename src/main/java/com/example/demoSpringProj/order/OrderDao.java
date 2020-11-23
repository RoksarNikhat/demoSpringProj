package com.example.demoSpringProj.order;

import com.example.demoSpringProj.product.Product;
import com.example.demoSpringProj.user.User;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDao {
    private NamedParameterJdbcTemplate jdbcTemplate;

    public OrderDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> getOrders(OrderSearchParams params1) throws Exception {
        Map<String, Object> namedParameters = new HashMap<>();
        String sql = "select o.id,o.quantity,p.id as product_id,p.name as product_name,p.size as product_size,p.price as product_price,p.description as product_description,u.id as user_id,u.first_name,u.last_name,u.email from orders o join product p on o.product_id =p.id join user u on o.user_id=u.id where 1=1";
        if (!ObjectUtils.isEmpty(params1.getProductName())) {
            sql += " and upper(p.name) like concat('%',upper(:productName),'%')";
            namedParameters.put("productName", params1.getProductName());

        }
        if (!ObjectUtils.isEmpty(params1.getUserName())) {
            sql += " and upper(u.first_name) like concat('%',upper(:userName),'%')";
            namedParameters.put("userName", params1.getUserName());

        }
        if (!ObjectUtils.isEmpty(params1.getMinAmount())) {
            sql += " and o.quantity*p.price >= :minAmount ";
            namedParameters.put("minAmount", params1.getMinAmount());

        }
        if (!ObjectUtils.isEmpty(params1.getMinAmount())) {
            sql += " and o.quantity*p.price <= :maxAmount ";
            namedParameters.put("maxAmount", params1.getMaxAmount());

        }
        List<Order> orders = new ArrayList<>();
        jdbcTemplate.query(sql,namedParameters,rs ->{
            Order  order = new Order();
            order.setId(rs.getLong("ID"));
            Product product = new Product();
            product.setId(rs.getLong("PRODUCT_ID"));
            product.setName(rs.getString("PRODUCT_NAME"));
            product.setDescription(rs.getString("PRODUCT_DESCRIPTION"));
            product.setSize(rs.getString("PRODUCT_SIZE"));
            product.setPrice(rs.getInt("PRODUCT_PRICE"));
            order.setProduct(product);
            User user = new User();
            user.setId(rs.getLong("USER_ID"));
            user.setFirstName(rs.getString("FIRST_NAME"));
            user.setLastName(rs.getString("LAST_NAME"));
            user.setEmail(rs.getString("EMAIL"));
            order.setUser(user);
            order.setQuantity(rs.getInt("QUANTITY"));

            orders.add(order);

        });
        return orders;

        //productname
        //username
        //minamount
        //maxamount
    }
}
