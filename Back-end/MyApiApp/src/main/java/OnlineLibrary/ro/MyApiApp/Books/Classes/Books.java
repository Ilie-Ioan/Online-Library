package OnlineLibrary.ro.MyApiApp.Books.Classes;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @SequenceGenerator(
            name = "books_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue
            (
                    generator = "books_id_sequence",
                    strategy = GenerationType.SEQUENCE
            )
    private long id;

    private String title;
    private String author;
    private int year;
    private boolean status;

    public Books(String title, String author, int year,boolean status) {
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

    public long getId() {
        return id;
    }

}
