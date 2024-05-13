package manage;

import model.Book;

import java.util.List;

public interface IManager <T>{
    void add(T t);
    boolean delete(int id);
    int findById(int id);
    List<Book> findByName(String name);
    boolean edit (int id, T t);
    List<T> findAll();
}
