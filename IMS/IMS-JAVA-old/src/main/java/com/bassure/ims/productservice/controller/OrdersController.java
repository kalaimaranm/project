package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.collection.Orders;
import com.bassure.ims.productservice.request.OrderRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @PostMapping("/addorder")
    public ResponseEntity addOrdersDetails(@RequestBody OrderRequest orderRequest) {

        return ordersService.addOrder(orderRequest);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity getAllOrders() {
        return ordersService.getAllOrders();
    }

    @PutMapping("/updateOrders")
    public ResponseEntity upddateOrders(@RequestBody Orders orders) {
        return ResponseEntity.builder().build();
    }
}
