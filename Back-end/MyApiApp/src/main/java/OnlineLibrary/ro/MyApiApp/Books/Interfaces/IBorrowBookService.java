package OnlineLibrary.ro.MyApiApp.Books.Interfaces;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;

import java.util.UUID;

public interface IBorrowBookService {
    void BorrowBook(UUID id);
}
