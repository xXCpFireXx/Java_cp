package database;

import java.util.List;

public interface Crud {
    public Object insert(Object object);
    public List<Object> findAll();
    public boolean update(Object object);
    public boolean delete(Object object);
}
