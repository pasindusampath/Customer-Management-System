package repo.custom.impl;

import entity.custom.Customer;
import org.hibernate.Session;
import repo.custom.CustomerRepo;


public class CustomerRepoImpl implements CustomerRepo {
    @Override
    public Customer add(Customer customer, Session session) {
        int save = (int) session.save(customer);
        customer.setId(save);
        return customer;
    }

    @Override
    public Customer update(Customer customer, Session session) {
        session.update(customer);
        return customer;
    }

    @Override
    public Customer search(String s, Session session) {
        return session.get(Customer.class, s);
    }

    @Override
    public void delete(Customer customer, Session session) {
        session.delete(customer);
    }
}
