package model;

public class Book {
    private int id;
    private String name;
    private String author;
    private String category;
    private int price;

    public Book(int id, String name, String author, String category, int price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "id: " + id + "\t" +
                " name: " + name  + "\t" +
                " author: " + author  + "\t" +
                " category: " + category + "\t" +
                " price: " + price
                ;
    }

   public String getData(){
        return id + "," + name + "," + author + "," + category + "," + price + "\n";
   }
}
