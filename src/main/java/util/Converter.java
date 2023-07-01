package util;

import dto.custom.CustomerDTO;
import entity.custom.Customer;

public class Converter {
    public static Customer toCustomer(CustomerDTO customer){
        return new Customer(customer.getId(), customer.getName(), customer.getContact(), customer.getAddress(),
                customer.getGmail(), customer.getGender());
    }

    public static CustomerDTO  toCustomerDTO(Customer customer){
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getContact(), customer.getAddress(),
                customer.getGmail(), customer.getGender());
    }
}
