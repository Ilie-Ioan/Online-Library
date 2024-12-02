package OnlineLibrary.ro.MyApiApp.Books.Interfaces;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;

import java.util.UUID;

public interface IUpdateBookService {
    void UpdateBook(Books books, UUID id);
}
