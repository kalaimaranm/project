package com.bassure.khatabook.controller;

import com.bassure.khatabook.model.LineItem;
import com.bassure.khatabook.model.Order;
import com.bassure.khatabook.model.Product;
import com.bassure.khatabook.service.PlaceOrderService;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlaceOrderController {

    @Autowired
    PlaceOrderService placeOrderService;

    @GetMapping("/shopping")
    public String getAllProducts(ModelMap model) throws SQLException, ClassNotFoundException {

        System.out.println("inside shopping");
        Product[] products = placeOrderService.getAllProduct();
        model.addAttribute("products", products);
        for (Product product : products) {

            System.out.println(product);
        }

        return "order/shopping";
    }

    @PostMapping("/check-out")
    public String checkoutCart(HttpServletRequest request, ModelMap model) throws ClassNotFoundException, SQLException {

        String[] id = request.getParameterValues("id");
        String[] quantity = request.getParameterValues("quantity");
        String[] price = request.getParameterValues("price");
        String[] name = request.getParameterValues("name");

        System.out.println("id :  " + Arrays.toString(id));
        System.out.println("quantity :  " + Arrays.toString(quantity));
        System.out.println("price :  " + Arrays.toString(price));
        System.out.println("name :  " + Arrays.toString(name));

        int[] stringToIntId = Stream.of(id).mapToInt(Integer::parseInt).toArray();
        int[] stringToIntQuantity = Stream.of(quantity).mapToInt(Integer::parseInt).toArray();
        double[] stringToDoublePrice = Stream.of(price).mapToDouble(Double::parseDouble).toArray();

        System.out.println(Arrays.toString(stringToIntId));
        System.out.println(Arrays.toString(stringToIntQuantity));
        System.out.println(Arrays.toString(stringToDoublePrice));
        System.out.println(Arrays.toString(name));

        LineItem[] lineItem = new LineItem[stringToIntId.length];

        int orderId = placeOrderService.genOrderId();

        double cartTotal = 0;

//       line-item object creation from request
        for (int i = 0; i < stringToIntId.length; i++) {

            lineItem[i] = new LineItem(orderId,
                    stringToIntId[i],
                    stringToIntQuantity[i],
                    name[i],
                    stringToDoublePrice[i]);
            cartTotal = cartTotal + (stringToIntQuantity[i] * stringToDoublePrice[i]);

        }

        Order order = new Order(orderId,
                (int) request.getSession().getAttribute("customerId"),
                cartTotal,
                LocalDateTime.now().toString(),
                "successfull",
                lineItem);

        request.getSession().setAttribute("order", order);
        request.getSession().setAttribute("totalProduct", order.getLineItem().length);
        return "order/cart-items";
    }

    @GetMapping("/cart-items")
    public String cartItem() {

        return "order/cart-items";
    }

}
