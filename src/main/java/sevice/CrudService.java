package sevice;

import dto.SuperDto;

import java.io.Serializable;

public interface CrudService<T extends SuperDto,ID extends Serializable> extends SuperService{
    T add(T t);
    T update(T t);
    T search(ID id);
    boolean delete(T t);
}
