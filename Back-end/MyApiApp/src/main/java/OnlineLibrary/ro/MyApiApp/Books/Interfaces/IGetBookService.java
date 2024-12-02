package OnlineLibrary.ro.MyApiApp.Books.Interfaces;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;

import java.util.List;

public interface IGetBookService {
    List<Books> getAllBooks();
}
