package com.example.demoSpringProj.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
}
