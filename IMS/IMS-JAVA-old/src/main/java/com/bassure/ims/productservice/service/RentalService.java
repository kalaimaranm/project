
package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.Rental;
import java.util.List;



public interface RentalService {
   public Rental addRental(Rental rental);
   public List<Rental> getRental();
   public Rental getRentalById(String rentalId);
   public Rental updateRental(String rentalId,Rental rental);
   public String deleteRental(String rentalId);
    
    
}
