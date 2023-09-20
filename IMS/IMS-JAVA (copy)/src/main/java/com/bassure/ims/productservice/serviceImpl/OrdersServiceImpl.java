
package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Orders;
import com.bassure.ims.productservice.repository.OrderRepository;
import com.bassure.ims.productservice.service.OrdersService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrdersServiceImpl implements OrdersService{
    
    @Autowired
    private OrderRepository orderrepository;
    
    
    @Override
    public Orders addOrdersDetails(Orders orders){
        LocalDateTime date=LocalDateTime.now();
        orders.setCreateAt(date);
        return orderrepository.save(orders);
    }
    
    @Override
    public List<Orders> getAllOrders(){
        return orderrepository.findAll();
    }
    
    @Override
    public Orders updateOrdersDetails(Orders order){
        LocalDateTime date=LocalDateTime.now();
        order.setUpdatedAt(date);
        return orderrepository.save(order);
    } 
}
