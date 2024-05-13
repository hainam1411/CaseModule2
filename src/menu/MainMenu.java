package menu;

import manage.BookManagement;
import model.Book;
import java.util.Scanner;


public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    BookManagement bookManagement = new BookManagement();

    public void displayMenu() {
        boolean exit = true;

        do {
            try {
                int choice = showMenuOption(scanner);
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        showMenuAdd();
                        break;
                    case 2:
                        showMenuDelete();
                        break;
                    case 3:
                        showMenuSearch();
                        break;
                    case 4:
                        showMenuEdit();
                        break;
                    case 5:
                        showList();
                        break;
                    case 6:
                        exit = false;
                        System.out.println("Good bye!");
                        break;
                    default:
                        System.err.println("Please enter number 1-6");
                }
            }catch (Exception e){
                System.err.println("Don't enter alphabet or special char");
                scanner.nextLine();
            }

        } while (exit);
    }

    private int showMenuOption(Scanner scanner) {
        System.out.println("------------BOOK MANAGEMENT-------------");
        System.out.println("1. Add books");
        System.out.println("2. Delete book");
        System.out.println("3. Search book");
        System.out.println("4. Change information's book");
        System.out.println("5. Show book list");
        System.out.println("6. exit");
        System.out.print("Your choice is: ");
        return scanner.nextInt();
    }

    public void showMenuAdd() {
        System.out.println("==== ADD BOOK ====");
        try {
            System.out.print(" Enter id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter name's book: ");
            String name = scanner.nextLine();
            System.out.println("Enter author: ");
            String author = scanner.nextLine();
            System.out.print("Enter category: ");
            String category = scanner.nextLine();
            System.out.print("Enter price: ");
            int price = Integer.parseInt(scanner.nextLine());
            Book book = new Book(id, name, author, category, price);
            bookManagement.add(book);
            System.out.println("Add successfully!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void showMenuDelete() {
        System.out.println("==== DELETE BOOK ====");
        try {
            System.out.print("Enter id you want to delete: ");
            int del = Integer.parseInt(scanner.nextLine());
            bookManagement.delete(del);
            System.out.println("Book is deleted!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void showMenuSearch() {
        System.out.println("==== SEARCH ====");
        System.out.print("Enter book you want to search: ");
        String nameSearch = scanner.nextLine();
        bookManagement.findByName(nameSearch);
        for (Book book : bookManagement.findByName(nameSearch)) {
            System.out.println(book);
        }
    }

    public void showMenuEdit() {
        System.out.println(" ==== EDIT INFORMATION BOOK ==== ");
        try {
            System.out.println("Enter id book: ");
            int idEdit = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new name:");
            String name = scanner.nextLine();
            System.out.print("Enter new author:");
            String author = scanner.nextLine();
            System.out.print("Enter category:");
            String category = scanner.nextLine();
            System.out.println("Enter new price: ");
            int price = Integer.parseInt(scanner.nextLine());
            Book newBook = new Book(idEdit, name, author, category, price);
            bookManagement.edit(idEdit, newBook);
            System.out.println("Information changed!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void showList() {
        for (Book book : bookManagement.findAll()) {
            System.out.println(book);
        }
    }
}
