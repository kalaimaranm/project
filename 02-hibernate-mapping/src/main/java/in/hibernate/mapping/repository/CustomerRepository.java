package in.hibernate.mapping.repository;

import in.hibernate.mapping.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    private EntityManager entityManager;

    @Transactional
    public Customer getCustomer(Long id) {

//        entityManager.getTransaction().begin();;
        return entityManager.find(Customer.class, id);

    }

    @Transactional
    public Customer addCustomer(Customer customer) {

        return entityManager.merge(customer);
    }

    @Transactional
    public boolean deletCustomer(Long id) {

        entityManager.remove(entityManager.find(Customer.class, id));
        return true;
    }

}