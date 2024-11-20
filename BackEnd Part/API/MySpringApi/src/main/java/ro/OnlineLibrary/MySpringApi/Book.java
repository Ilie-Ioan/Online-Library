package ro.OnlineLibrary.MySpringApi;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {



    @Id
    @SequenceGenerator(name = "user_id",allocationSize = 1)
    @GeneratedValue(generator = "user_id",strategy = GenerationType.SEQUENCE)
    private Long book_id;
    private String Title;
    private String Author;
    private String Description;
    private String ISBN;
    private boolean available;

    public Book() {
    }

    public Book(String title, String author, String description, String ISBN, boolean avaible) {
        Title = title;
        Author = author;
        Description = description;
        this.ISBN = ISBN;
        available = avaible;
    }

    public Long getBook_id() {
        return book_id;
    }
    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getDescription() {
        return Description;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
