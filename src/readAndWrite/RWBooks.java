package readAndWrite;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RWBooks {
    private File file = new File("src/data/books.csv");

    public void writeFile(List<Book> books) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Book book : books) {
                line += book.getData();
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Book> readFile() {
        List<Book> books = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                 String[] data = line.split(",");
                books.add(new Book(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4])));


            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }
}
