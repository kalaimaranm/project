package com.bassure.spring.basics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductController {

    @GetMapping("/newProduct")
    public Product newProduct() {

        return new Product(10001l, "Ghee-Roasted-Nuts", "Eatable Product");
    }

    @GetMapping("/products")
    public String addProduct() {

        return "newProduct";
    }
//    @PostMapping()
//    public String addProduct()

}
