package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.Assert;
import com.bassure.ims.productservice.collection.Rental;
import com.bassure.ims.productservice.request.AssertRequest;

import java.util.List;

public interface AssertService {

    public Assert addAssert(AssertRequest anAssert);

    public List<Assert> getAssert();

    public Assert getAssertById(String productId);

    public List<Assert> getAggregatedProducts();

    public List<Assert> retrieveAggregatedAssert();

    public String updateAssert(String assertId, AssertRequest anAssertRequest);
}
