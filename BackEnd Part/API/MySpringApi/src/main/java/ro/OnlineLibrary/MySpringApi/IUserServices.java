package ro.OnlineLibrary.MySpringApi;

import java.util.List;

public interface IUserServices {
    List<Book> getAllBooks();
    void borrow_book(User utilizator,Book carte);

    void return_book(User utilizator,Book carte);
}
