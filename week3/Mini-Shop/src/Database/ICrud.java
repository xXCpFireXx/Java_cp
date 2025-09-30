package Database;
import java.util.List;

public interface ICrud <T>{
    public T insert(T obj);
    public List<T> findAll();
    public boolean update(T obj);
    public boolean delete(T obj);
    public T findById(int id);
    public List<T> findByName(String name);
}
