package com.bassure.transaction;

import com.bassure.dao.ProductDAO;
import com.bassure.dao.ProductDAOImpl;
import com.bassure.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTransaction {

    @Autowired
    private static ProductService productService;

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(ConfigurationClass.class);

        productService = context.getBean(ProductService.class);
//            ProductDAO product = context.getBean(ProductDAO.class);
//            context.registerShutdownHook();
        productService.insertProduct();

    }
}
