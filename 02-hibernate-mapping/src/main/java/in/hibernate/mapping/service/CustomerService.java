package in.hibernate.mapping.service;

import in.hibernate.mapping.entity.Customer;
import in.hibernate.mapping.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRespository;
    
    public Customer getCustomer(Long id) {
        
        return customerRespository.getCustomer(id);
    }
    
    public Customer addCustomer(Customer customer) {
        
        return customerRespository.addCustomer(customer);
    }
    
    public boolean deleteCustomer(Long id) {
        
        return customerRespository.deletCustomer(id);
    }
}
