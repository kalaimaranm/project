
package com.bassure.ims.productservice.repository;

import com.bassure.ims.productservice.collection.Assert;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AssertRepository extends MongoRepository<Assert, String> {


    //         @Aggregation([
//        "{$lookup: {from: 'brand', localField: 'brand_id', foreignField: '_id', as: 'brandData'}}",
//        "{$project: { _id: 1, product_name: 1, product_desc: 1, price: 1, serial_no: 1, ownership: 1, tenant_id: 1, brand_id: 1, model_id: 1, order_id: 1, warranty: 1, created_at: 1, created_by: 1, updated_by: 1, status: 1, brandData: 1 }}"
//    ])
//       @Query(value = "{" +
//            "$lookup: { from: 'brand', localField: 'brand_id', foreignField: '_id', as: 'brandData' }," +
//            "$project: { _id: 1, product_name: 1, product_desc: 1, price: 1, serial_no: 1, ownership: 1, tenant_id: 1, brand_id: 1, model_id: 1, order_id: 1, warranty: 1, created_at: 1, created_by: 1, updated_by: 1, status: 1, brandData: 1 }" +
//            "}")
    @Query(value = "{" +
            "$lookup: { " +
            "   from: 'brand', " +
            "   localField: 'brand_id', " +
            "   foreignField: '_id', " +
            "   as: 'brandData' " +
            "}," +
            "$project: { _id: 1, product_name: 1, product_desc: 1, price: 1, serial_no: 1, ownership: 1, tenant_id: 1, brand_id: 1, model_id: 1, order_id: 1, warranty: 1, created_at: 1, created_by: 1, updated_by: 1, status: 1, brandData: 1 }" +
            "}")
    List<Assert> retrieveAggregatedProducts();
}


