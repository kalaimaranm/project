package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Orders;
import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.config.HttpStatusMessage;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.config.UtilsResponse;
import com.bassure.ims.productservice.repository.AssetRepository;
import com.bassure.ims.productservice.repository.OrderRepository;
import com.bassure.ims.productservice.repository.SupplierRepository;
import com.bassure.ims.productservice.request.OrderRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.OrdersService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private SupplierServiceImpl supplierService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private HttpStatusCode status;

    @Autowired
    private HttpStatusMessage httpStatusMessage;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity addOrder(OrderRequest orderRequest) {
        Orders order = new Orders();
        order.setOrderId(sequenceGeneratorService.generateSequence(UtilsConfig.getORDER_SEQUENCE_NAME()));
        BeanUtils.copyProperties(orderRequest, order);
        order.setStatus("ACTIVE");
        order.setCreateAt(LocalDateTime.now());
        if (supplierRepository.findById(orderRequest.getSupplierId()).isPresent()
                && orderRepository.save(order) != null) {

            return UtilsResponse.responsesEntity(status.getSuccess(), httpStatusMessage.getSuccess());
        } else {
            return UtilsResponse.responsesEntity(status.getError(), Map.of(httpStatusMessage.getErrorKey(), httpStatusMessage.getFailed()));
        }
    }

    @Override
    public ResponseEntity getOrder(String id) {

        Optional<Orders> order = orderRepository.findById(id);

        if (order.isPresent()) {
            return UtilsResponse.responsesEntity(status.getSuccess(), order);
        }
        return UtilsResponse.responsesEntity(status.getError(), Map.of(httpStatusMessage.getErrorKey(), httpStatusMessage.getFailed()));
    }

    @Override
    public ResponseEntity getAllOrders() {

        List<Orders> order = orderRepository.findAll();
        if (order != null) {

            return UtilsResponse.responsesEntity(status.getSuccess(), order);
        }

        return UtilsResponse.responsesEntity(status.getError(), Map.of(httpStatusMessage.getErrorKey(), httpStatusMessage.getFailed()));
    }

    @Override
    public ResponseEntity updateOrder(String id, OrderRequest orderRequest) {

        Optional<Orders> orderResult = orderRepository.findById(id);
        Orders order = new Orders();
        order.setOrderId(id);
        BeanUtils.copyProperties(orderResult.get(), order);
        order.setCreateAt(orderResult.get().getCreateAt());
        if (orderResult.isPresent() && orderRepository.save(order).getOrderId() != null) {

            return UtilsResponse.responsesEntity(status.getSuccess(), "order updated successfully");

        }
        return UtilsResponse.responsesEntity(status.getError(), Map.of(httpStatusMessage.getErrorKey(), httpStatusMessage.getFailed()));
    }

    public ResponseEntity deleteOrder(String id) {



        if(getOrder(id).getCode() == status.getSuccess()
                && assetRepository.existsByOrderId(id)) {

            Query query = new Query(Criteria.where("id").is(id));
            Update update = new Update().set("status", "INACTIVE");
            UpdateResult result = mongoTemplate.updateFirst(query, update, Orders.class);
            if(result.getModifiedCount() > 0) {

                return UtilsResponse.responsesEntity(status.getSuccess(), "order successfully deleted");
            }
        }
        return UtilsResponse.responsesEntity(status.getFailed(), Map.of(httpStatusMessage.getErrorKey(), httpStatusMessage.getFailed()));
    }

}
