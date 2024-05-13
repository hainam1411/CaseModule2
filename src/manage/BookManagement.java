package manage;

import model.Book;
import readAndWrite.RWBooks;

import java.util.ArrayList;
import java.util.List;

public class BookManagement implements IManager<Book> {
    private List<Book> bookList;
    private RWBooks rwBooks = new RWBooks();

    public BookManagement() {
        bookList = rwBooks.readFile();
    }

    @Override
    public void add(Book book) {
        bookList.add(book);
        rwBooks.writeFile(bookList);
    }

    @Override
    public boolean delete(int id) {
        int index = findById(id);
        if (index == -1) {
            return false;
        }
        this.bookList.remove(index);
        rwBooks.writeFile(bookList);
        return true;
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (id == bookList.get(i).getId()) {
                return i;
            }
        }
        rwBooks.writeFile(bookList);
        return -1;
    }

    @Override
    public List<Book> findByName(String name) {
        List<Book> findName = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getName().toLowerCase().contains(name.toLowerCase())) {
                findName.add(book);
            }
        }

        rwBooks.writeFile(bookList);
        return findName;
    }

    @Override
    public boolean edit(int id, Book book) {
        int index = findById(id);
        if (index == -1) {
            return false;
        }
        this.bookList.set(index, book);
        rwBooks.writeFile(bookList);
        return true;
    }

    @Override
    public List<Book> findAll() {
        return bookList;
    }
}
