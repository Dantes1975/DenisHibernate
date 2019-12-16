package repozitory;

import java.util.List;

public interface Crud<T> {
    List<T> getAll();
    T getById(long id);
    T save(T t);
    void delete(long id);
    T update(T t);

}

