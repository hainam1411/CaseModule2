import manage.BookManagement;
import model.Book;

public class Test {
    public static void main(String[] args) {
        BookManagement bookManagement = new BookManagement();
            for (Book book: bookManagement.findAll()){
                System.out.println(book);
            }
            int[] a = {1,2,3};
            for (int book: a){
                System.out.println(book);
            }

    }
}
