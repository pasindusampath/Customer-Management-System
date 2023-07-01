package sevice.custom.impl;

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
        return null;
    }

    @Override
    public CustomerDTO search(String s) {
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
    public boolean delete(CustomerDTO customerDTO) {
        return false;
    }
}
