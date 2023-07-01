package util;

import repo.custom.CustomerRepo;
import repo.custom.impl.CustomerRepoImpl;
import sevice.custom.CustomerService;
import sevice.custom.impl.CustomerServiceImpl;
import repo.SuperRepo;

public class RepoFactory {
    private static RepoFactory factory;
    private CustomerRepo customer;
    public enum RepoType{
        CUSTOMER
    }

    private RepoFactory(){
        customer=new CustomerRepoImpl();
    }


    public static RepoFactory getInstance(){
        return factory==null ? factory=new RepoFactory() : factory;
    }

    public <T extends SuperRepo>T getRepo(RepoType type){
        switch (type){
            case CUSTOMER:return (T)customer;
        }
        return null;
    }

}
