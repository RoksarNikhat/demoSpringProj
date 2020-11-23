package com.example.demoSpringProj.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description="Operation related to order")
@RestController
@Slf4j
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
@ApiOperation(value="Operation to save order")
    @PostMapping("/api/save-order")
    public Order saveOrder(@RequestBody Order order) throws Exception{
        try{
            return orderService.saveOrder(order);
        }
        catch(Exception e){
            log.error("problem in saving order",e);
            throw e;
        }

    }
    @ApiOperation(value="Operation to get order")
    @PostMapping ("/api/get-orders")
    public List<Order> getOrders(@RequestBody OrderSearchParams params1)throws Exception{
        try{
            return orderService.getOrders(params1);
        }
        catch(Exception e){
            log.error("Problem while fetching orders");
            throw e;
        }
    }
}
