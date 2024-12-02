package OnlineLibrary.ro.MyApiApp.Books.Classes;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String author;
    private int year;
    private boolean status;

    public Books() {
        this.title = "No name";
        this.author = "No author";
        this.year = 0;
        this.status = true;
    }

    public Books(String title, String author, int year, boolean status) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public UUID getId() {
        return id;
    }
}
