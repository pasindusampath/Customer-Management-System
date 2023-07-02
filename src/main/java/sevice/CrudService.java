package sevice;

import dto.SuperDto;

import java.io.Serializable;
import java.util.List;

public interface CrudService<T extends SuperDto,ID extends Serializable> extends SuperService{
    T add(T t);
    T update(T t);
    T search(ID id);
    List<T> getAll();
    boolean delete(ID id);
}
