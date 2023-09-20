
package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.collection.Rental;
import com.bassure.ims.productservice.response.ResponseBody;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.response.ResponseHeader;
import com.bassure.ims.productservice.config.UtilsConfig;

import java.util.Map;

import com.bassure.ims.productservice.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("rental")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    public ResponseEntity addRental(@RequestBody Rental rental) {
        Rental addRental = rentalService.addRental(rental);
        if (addRental != null) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(addRental).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("", "")).build())
                    .build();
        }

    }


}
