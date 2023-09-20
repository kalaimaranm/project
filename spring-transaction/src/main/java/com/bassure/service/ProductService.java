package com.bassure.service;

import com.bassure.dao.ProductDAO;
import com.bassure.model.Product;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

//    @Transactional(rollbackFor = {Exception.class})   - checked
//    @Transactional(noRollbackFor = {RuntimeException.class}) - uncheked
    @Transactional(propagation = Propagation.REQUIRED)   // START
    public void insertProduct() throws Exception {

//        ProductDAO productDAO = new ProductDAOImpl();
        for (int i = 1; i < 10; i++) {
            Product product = new Product(i, "product " + i, LocalDate.now());
            productDAO.saveProduct(product);    // TRANSACTION SHARED TO saveProduct() method
//            if (i == 5) {
//                throw new Exception("user defined run time exception occured ");
//            }
        }
        
//         COMMIT

    }

}
