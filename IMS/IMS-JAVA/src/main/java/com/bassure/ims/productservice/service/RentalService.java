
package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.request.RentalRequest;
import com.bassure.ims.productservice.response.ResponseEntity;

public interface RentalService {
    ResponseEntity addRental(RentalRequest rentalRequest);
    ResponseEntity getAllRental();
    ResponseEntity getRental(String rentalId);
    ResponseEntity updateRental(String rentalId, RentalRequest rentalRequest);
    ResponseEntity deleteRental(String rentalId);

    
}
