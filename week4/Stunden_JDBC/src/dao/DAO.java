package dao;

public interface DAO<T> {
    void insertar(T t);
    void actualizar(T t);
    void eliminar(int id);
    T obtenerPorId(int id);
    List<T> obtenerTodos();
}