package com.bassure.khatabook.controller;

import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/signup")
    public String signupForm(@ModelAttribute("customer") Customer customer) throws SQLException, ClassNotFoundException {

        return "customer/create-account";
    }

    @PostMapping(path = "/addcustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer, ModelMap model) throws SQLException, ClassNotFoundException {

        if (customerService.addCustomer(customer)) {
            model.addAttribute("customerprofile", true);

            return "customer/customer-profile";
        } else {
            return "customer/customer-failed-message";
        }

    }

    @GetMapping("/login")
    public String login(ModelMap model) {
        model.addAttribute("action", "viewcustomerprofile");

        return "customer/customer-login-form";
    }

    @RequestMapping("/viewcustomerprofile")
//    public String viewProfile(@RequestParam("phone") String customerPhone, ModelMap model) throws SQLException, ClassNotFoundException {
    public String viewProfile(HttpServletRequest request, ModelMap model) throws SQLException, ClassNotFoundException {

//        Customer customer = customerService.getCustomerByPhone(customerPhone);
        System.out.println("customerId: " + (int) request.getSession().getAttribute("customerId"));
        Customer customer = customerService.getCustomerById((int) request.getSession().getAttribute("customerId"));
        if (customer != null) {
            model.addAttribute("customer", customer);
            model.addAttribute("customerprofile", true);
            return "customer/customer-profile";
        }
        return "customer/customer-profile-notfound";
    }

    @GetMapping("/deletecustomer")
//    public String deleteCustomer(@RequestParam("id") int id, ModelMap model) throws SQLException, ClassNotFoundException {
    public String deleteCustomer(HttpServletRequest request, ModelMap model) throws SQLException, ClassNotFoundException {

        if (customerService.deleteCustomer((int) request.getSession().getAttribute("customerId"))) {
            System.out.println("inside tdeltet true");
            model.addAttribute("accountDeletionStatus", true);
        }
        return "customer/account-delete-message";
    }

    @PostMapping("/paydebt")
//    public String payDebt(@RequestParam("id") int id, @RequestParam("amount") double debtAmount, ModelMap model) throws SQLException, ClassNotFoundException {
    public String payDebt(HttpServletRequest request, @RequestParam("amount") double debtAmount, ModelMap model) throws SQLException, ClassNotFoundException {

        int customerId = (int) request.getSession().getAttribute("customerId");
        if (customerService.payDebt(customerId, debtAmount)) {
            model.addAttribute("paymentStatus", true);
            model.addAttribute("payment", customerService.getPaymentDetail(customerId));

        }
        return "customer/debt-transaction-message";

    }

//    no use
    @GetMapping("/update-login")
    public String updateCustomerLogin(ModelMap model) {

        model.addAttribute("action", "update-customer-detail");
        return "customer/customer-login-form";
    }

    @GetMapping("/update-customer-detail")
//    public String updateCustomerDetail(@RequestParam("phone") String phone, ModelMap model) throws SQLException, ClassNotFoundException {
    public String updateCustomerDetail(HttpServletRequest request, ModelMap model) throws SQLException, ClassNotFoundException {

//        Customer customer = customerService.getCustomerByPhone(phone);
        Customer customer = customerService.getCustomerById((int) request.getSession().getAttribute("customerId"));
        model.addAttribute("customer", customer);

        System.out.println("customer : " + customer);
        if (customer != null) {
            return "customer/update-customer-form";
        }
        return "customer/customer-profile-notfound";

    }

    @PostMapping("/update-customer")
//    public String updateCustomer(@ModelAttribute("customer") Customer customer, ModelMap model) throws SQLException, ClassNotFoundException {
    public String updateCustomer(@ModelAttribute("customer") Customer customer, ModelMap model) throws SQLException, ClassNotFoundException {

        if (customerService.updateCustomer(customer)) {

            model.addAttribute("updateCustomerStatus", true);
            model.addAttribute("phone", customer.getPhone());
        }
        return "customer/customer-updation-message";
    }

}
