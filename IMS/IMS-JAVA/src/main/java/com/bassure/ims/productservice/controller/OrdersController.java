package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.request.OrderRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.OrdersService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @PostMapping("/addOrder")
    public ResponseEntity addOrder(@Valid @RequestBody OrderRequest orderRequest) {

        return ordersService.addOrder(orderRequest);
    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity getOrder(@Valid @PathVariable @NotNull(message = "id must not be empty") @NotBlank(message = "id must not be blank") String id) {
        return ordersService.getOrder(id);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity getAllOrder() {

        return ordersService.getAllOrders();
    }

    @PutMapping("/updateOrders/{id}")
    public ResponseEntity updateOrder(@Valid @PathVariable @NotNull(message = "id must not be empty")
                                      @NotBlank(message = "id must not be blank") String id, @RequestBody OrderRequest orderRequest) {
        return ordersService.updateOrder(id, orderRequest);
    }

    @DeleteMapping("/deletemodel/{id}")
    public ResponseEntity deleteOrder(@PathVariable String id) {

        return ordersService.deleteOrder(id);
    }

}
