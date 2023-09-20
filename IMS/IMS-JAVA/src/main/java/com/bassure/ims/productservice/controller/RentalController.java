package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.request.RentalRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/rental")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @PostMapping("/addrental")
    public ResponseEntity addRental(@RequestBody RentalRequest rentalRequest) {
        return rentalService.addRental(rentalRequest);
    }

    @GetMapping("/getallrental")
    public ResponseEntity getRental() {
        return rentalService.getAllRental();
    }

    @GetMapping("/getrentalByid/{rentalId}")
    public ResponseEntity getRentalById(@PathVariable String rentalId) {
        return rentalService.getRental(rentalId);
    }

    @PutMapping("/updateRental/{rentalId}")
    public ResponseEntity updatedRental(@PathVariable String rentalId, @RequestBody RentalRequest rentalRequest) {
        return rentalService.updateRental(rentalId, rentalRequest);
    }

    @DeleteMapping("/deleterental/{id}")
    public ResponseEntity deleteRental(@PathVariable String id) {

        return rentalService.deleteRental(id);
    }
}
