package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.Assert;

import java.util.List;

public interface AssertService {

    Assert addAssert(Assert anAssert);

    List<Assert> getAssert();

    Assert getAssertById(String productId);

    List<Assert> getAggregatedProducts();

    List<Assert> retrieveAggregatedAssert();
}
