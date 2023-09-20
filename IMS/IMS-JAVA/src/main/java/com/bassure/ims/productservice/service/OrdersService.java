package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.request.OrderRequest;
import com.bassure.ims.productservice.response.ResponseEntity;

public interface OrdersService {

     ResponseEntity addOrder(OrderRequest orderRequest);

     ResponseEntity getOrder(String id);

     ResponseEntity getAllOrders();

     ResponseEntity updateOrder(String id, OrderRequest orderRequest);

     ResponseEntity deleteOrder(String id);
}
