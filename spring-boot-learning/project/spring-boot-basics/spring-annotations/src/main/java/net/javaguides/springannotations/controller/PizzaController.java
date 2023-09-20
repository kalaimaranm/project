package net.javaguides.springannotations.controller;

import net.javaguides.springannotations.service.NotificationService;
import net.javaguides.springannotations.service.Pizza;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaController {

//    @Autowired
//    @Qualifier("vegPizza")
    private Pizza pizza;

    private NotificationService notification;

//    @Autowired
//    @Qualifier not applicable
    public PizzaController(@Qualifier("nonVegPizza") Pizza pizza, NotificationService notification) {
        this.pizza = pizza;
        this.notification = notification; 
    }

//    @Autowired
//    public void setVegPizza(VegPizza vegPizza) {
//        this.vegPizza = vegPizza;
//    }
    public String getPizza() {
        return pizza.getPizza();
    }

    public String getNotification() {

        return notification.status();
    }
}
