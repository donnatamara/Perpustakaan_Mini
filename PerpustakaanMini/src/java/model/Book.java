package model;

public class Book {
    private String id;
    private String title;
    private String author;
    private int stock;

    public Book() {}

    // Constructor untuk ID string (misal pakai UUID saat add)
    public Book(String id, String title, String author, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }

    // Constructor untuk ID integer (misal saat edit / get by ID)
    public Book(int id, String title, String author, int stock) {
        this.id = String.valueOf(id);
        this.title = title;
        this.author = author;
        this.stock = stock;
    }

    // Getter & Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
