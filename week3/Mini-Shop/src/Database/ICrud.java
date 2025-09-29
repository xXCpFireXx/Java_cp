package Database;
import java.util.List;

public interface ICrud {
    public Object insert(Object obj);
    public List<Object> findAll();
    public boolean update(Object obj);
    public boolean delete(Object obj);
    public Object findById(int id);
}
