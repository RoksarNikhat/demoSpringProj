package com.example.demoSpringProj.order;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private OrderDao orderDao;

    public OrderServiceImpl(OrderRepository orderRepository, OrderDao orderDao) {
        this.orderRepository = orderRepository;
        this.orderDao = orderDao;
    }


    @Override

    public Order saveOrder(Order order) throws Exception {
        order.setLastUpdatedTimestamp(new Date());
        return orderRepository.save(order);
    }


    @Override
    public List<Order> getOrders(OrderSearchParams params1) throws  Exception {
        return orderDao.getOrders(params1);
    }
}
