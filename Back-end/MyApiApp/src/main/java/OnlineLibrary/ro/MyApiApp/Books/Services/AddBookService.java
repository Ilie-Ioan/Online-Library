package OnlineLibrary.ro.MyApiApp.Books.Services;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import OnlineLibrary.ro.MyApiApp.Books.Interfaces.IAddBookService;
import OnlineLibrary.ro.MyApiApp.Books.Repository.BookRepository;

public class AddBookService implements IAddBookService {

    private final BookRepository bookRepository;

    public AddBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void AddBook(Books book) {
        bookRepository.save(book);
    }
}
