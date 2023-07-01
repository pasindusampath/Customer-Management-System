package repo.custom.impl;

import entity.custom.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repo.custom.CustomerRepo;

import java.util.List;


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
        return session.get(Customer.class, Integer.parseInt(s));
    }

    @Override
    public List<Customer> getAll(Session session) {
        // return session.createQuery("FROM Customer",List<Customer>.class);
        Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
        return query.list();
    }

    @Override
    public void delete(Customer customer, Session session) {
        session.delete(customer);
    }
}
