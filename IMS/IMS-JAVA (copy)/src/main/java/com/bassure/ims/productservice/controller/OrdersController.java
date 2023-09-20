
package com.bassure.ims.productservice.controller;


import com.bassure.ims.productservice.collection.Orders;
import com.bassure.ims.productservice.collection.ResponseEntity;
import com.bassure.ims.productservice.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrdersController {
    
    @Autowired
    OrdersService ordersservice;
    
    
    @PostMapping("/addorder")
    public Orders addOrdersDetails(@RequestBody Orders Order){
        return ordersservice.addOrdersDetails(Order);
    }
    
    @GetMapping("/getAllOrders")
    public List<Orders> getAllOrders(){
        return  ordersservice.getAllOrders();
    }   
    
    @PutMapping("/updateOrders")
    public ResponseEntity upddateOrders(@RequestBody Orders orders){
        return  ResponseEntity.builder().build();
    }
}
