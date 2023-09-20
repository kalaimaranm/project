package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.Orders;
import com.bassure.ims.productservice.request.OrderRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import java.util.List;

public interface OrdersService {

    public ResponseEntity addOrder(OrderRequest orderRequest);

    public ResponseEntity getOrder(String id);

    public ResponseEntity getAllOrders();

    public ResponseEntity updateOrder(String id, OrderRequest orderRequest);

}
