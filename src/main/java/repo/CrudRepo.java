package repo;

import entity.SuperEntity;
import org.hibernate.Session;

public interface CrudRepo<T extends SuperEntity,ID> extends SuperRepo {
    T add(T t, Session session);
    T update(T t,Session session);
    T search(ID id, Session session);
    void delete(T t, Session session);
}
