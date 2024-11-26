package OnlineLibrary.ro.MyApiApp.Books.Interfaces;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;

public interface IUpdateBookService {
    void UpdateBook(Books books, Long id);
}
