package com.example.demoSpringProj.order;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order saveOrder(Order order) throws Exception {
        return orderRepository.save(order);
    }
}
