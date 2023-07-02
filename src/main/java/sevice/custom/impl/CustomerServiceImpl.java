package sevice.custom.impl;

import org.hibernate.Transaction;
import sevice.custom.CustomerService;
import db.FactoryConfiguration;
import dto.custom.CustomerDTO;
import entity.custom.Customer;
import org.hibernate.Session;
import repo.custom.CustomerRepo;
import util.Converter;
import util.RepoFactory;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private FactoryConfiguration factory = FactoryConfiguration.getInstance();
    CustomerRepo repo = RepoFactory.getInstance().getRepo(RepoFactory.RepoType.CUSTOMER);

    @Override
    public CustomerDTO add(CustomerDTO customerDTO) {
        try (Session session = factory.getSession();){
            Customer customer = Converter.toCustomer(customerDTO);
            Customer add = repo.add(customer, session);
            CustomerDTO customerDTO1 = Converter.toCustomerDTO(add);
            return customerDTO1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        Transaction transaction = null;
        try(Session session = factory.getSession()) {
             transaction= session.beginTransaction();
            Customer customer = Converter.toCustomer(customerDTO);
            Customer update = repo.update(customer, session);
            transaction.commit();
            return Converter.toCustomerDTO(update);
        }catch (Throwable e){
            if(transaction!=null)
            transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerDTO search(String s) {
        try(Session session= factory.getSession()) {
            Customer search = repo.search(s, session);
            if(search==null){
                return null;
            }
            CustomerDTO customerDTO = Converter.toCustomerDTO(search);
            return customerDTO;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CustomerDTO> getAll() {
        try(Session session = factory.getSession()) {
            List<Customer> all = repo.getAll(session);
            List<CustomerDTO> list = new ArrayList<>();
            for (Customer ob : all){
                list.add(Converter.toCustomerDTO(ob));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            Customer search = repo.search(id, session);
            repo.delete(search, session);
            transaction.commit();
            return true;
        } catch (Throwable e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
}
