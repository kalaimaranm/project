package com.bassure.khatabook.controller;

import com.bassure.khatabook.model.Product;
import com.bassure.khatabook.service.ProductService;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/productform")
    public String addProductForm(@ModelAttribute("product") Product product) {

        return "product/add-product-form";
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute("product") Product product, ModelMap model) throws ClassNotFoundException, SQLException {

        System.out.println(product);
        if (productService.addProduct(product)) {

            model.addAttribute("producAdditionStatus", true);

        }

        return "product/add-product-message";
    }

    //    endpoint -> (3)
    @PostMapping("/updateproduct")
    public String updateProduct(@ModelAttribute("product") Product product, ModelMap model) throws SQLException, ClassNotFoundException {

        if (productService.updateProduct(product)) {
//            product = productService.getProductById(product.getId());
            model.addAttribute("productUpdationStatus", true);
            model.addAttribute("totalQuantity", product.getQuantity() + ProductService.productQuantityBeforeUpdate);
        }
        return "product/update-product-message";
    }

    //    endpoint -> (2)
    @GetMapping("/updateproductform")
    public String updateProductForm(@RequestParam("productId") int productId, @ModelAttribute("product") Product product, ModelMap model) throws SQLException, ClassNotFoundException {

        product = productService.getProductById(productId);
        model.addAttribute("productDetail", product);
        System.out.println(ProductService.productQuantityBeforeUpdate = product.getQuantity());

        return "product/update-product-form";
    }

//    endpoint -> (1)
    @GetMapping("/viewallproduct")
    public String viewAllProduct(ModelMap model) throws SQLException, ClassNotFoundException {

        Map<Integer, Product> products = productService.getAllProduct();

        model.addAttribute("products", products.values().toArray(new Product[products.size()]));

        return "product/view-all-product";

    }

    @RequestMapping("/deleteproduct")
    public String deleteProduct(@RequestParam("productId") int productId, ModelMap model) throws ClassNotFoundException, SQLException {

        if (productService.deleteProduct(30233)) {

            model.addAttribute("productdeletionStatus", true);
        }

        return "product/delete-product-message";
    }
}
