package com.example.demoSpringProj.order;

import com.example.demoSpringProj.product.Product;
import com.example.demoSpringProj.product.ProductSearchParams;

import java.util.List;

public interface  OrderService {
    Order saveOrder(Order order) throws Exception;

    List<Order> getOrders(OrderSearchParams params1) throws Exception;
}
