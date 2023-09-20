package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Orders;
import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.config.UtilsResponse;
import com.bassure.ims.productservice.repository.OrderRepository;
import com.bassure.ims.productservice.repository.SupplierRepository;
import com.bassure.ims.productservice.request.OrderRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.OrdersService;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrderRepository orderrepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierServiceImpl supplierService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private HttpStatusCode status;

//    @Override
//    public Orders addOrder(OrderRequest orderRequest) {
//
//        Orders order = new Orders();
//        order.setOrderId(sequenceGeneratorService.generateSequence(UtilsConfig.getORDER_SEQUENCE_NAME()));
//        BeanUtils.copyProperties(orderRequest, order);
//        return orderrepository.save(orders);
//    }
//
//    @Override
//    public Orders getOrder(String id) {
//
//    }
//
//    @Override
//    public List<Orders> getAllOrders() {
//        return orderrepository.findAll();
//    }
//
//    @Override
//    public Orders updateOrdersDetails(Orders order) {
//        LocalDateTime date = LocalDateTime.now();
//        order.setUpdatedAt(date);
//        return orderrepository.save(order);
//    }
    @Override
    public ResponseEntity addOrder(OrderRequest orderRequest) {

        Orders order = new Orders();

        order.setOrderId(sequenceGeneratorService.generateSequence(UtilsConfig.getORDER_SEQUENCE_NAME()));
        BeanUtils.copyProperties(orderRequest, order);
        if (supplierRepository.findById(orderRequest.getSupplierId()).isPresent()
                && orderrepository.save(order) != null) {

            return UtilsResponse.responsesEntity(status.getSuccess(), status.getSuccess(), Map.of("", ""));
        } else {
            return UtilsResponse.responsesEntity(status.getError(), "supplier not found id - " + orderRequest.getSupplierId(), Map.of("", ""));
        }
    }

    @Override
    public ResponseEntity getOrder(String id) {

        return null;
    }

    @Override
    public ResponseEntity getAllOrders() {

        return null;
    }

    @Override
    public ResponseEntity updateOrder(String id, OrderRequest orderRequest) {

        return null;
    }

}
