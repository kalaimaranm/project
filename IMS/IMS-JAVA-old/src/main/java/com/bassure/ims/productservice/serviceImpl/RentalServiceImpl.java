
package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Rental;
import com.bassure.ims.productservice.repository.RentalRepository;
import com.bassure.ims.productservice.service.RentalService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RentalServiceImpl implements RentalService {


    @Autowired
    RentalRepository rentalRepo;

    @Override
    public Rental addRental(Rental rental) {
        return rentalRepo.save(rental);
    }

    @Override
    public List<Rental> getRental() {
        return rentalRepo.findAll();
    }

    @Override
    public Rental getRentalById(String rentalId) {
        Optional<Rental> rental = rentalRepo.findById(rentalId);
        return rental.get();
    }

    @Override
    public Rental updateRental(String rentalId, Rental rental) {
        return rentalRepo.save(rental);
    }

    @Override
    public String deleteRental(String rentalId) {
        return "";
    }

}
