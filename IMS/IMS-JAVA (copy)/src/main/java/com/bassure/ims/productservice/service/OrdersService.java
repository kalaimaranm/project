
package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.Orders;
import java.util.List;

public interface OrdersService {
    
    
    public Orders addOrdersDetails(Orders orders);
    
    public List<Orders> getAllOrders();
    
    public Orders updateOrdersDetails(Orders order);
    
}
