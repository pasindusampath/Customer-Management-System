package util;

import sevice.SuperService;
import sevice.custom.CustomerService;
import sevice.custom.impl.CustomerServiceImpl;

public class ServiceFactory {
    private static ServiceFactory factory;
    private CustomerService customerDao;

    public enum ServiceType{
        CUSTOMER
    }

    private ServiceFactory(){
        customerDao = new CustomerServiceImpl();
    }

    public static ServiceFactory getInstance(){
        return factory==null ? factory = new ServiceFactory() : factory;
    }

    public <T extends SuperService>T getService(ServiceType type){
        switch (type){
            case CUSTOMER:return (T)customerDao;
        }
        return null;
    }

}
