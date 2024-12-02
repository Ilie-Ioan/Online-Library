package OnlineLibrary.ro.MyApiApp.Books.Services;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import OnlineLibrary.ro.MyApiApp.Books.Interfaces.IAddBookService;
import OnlineLibrary.ro.MyApiApp.Books.Repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class AddBookService implements IAddBookService {

    private final BookRepository bookRepository;
    private final ValidateBookTitle validateBookTitle;

    public AddBookService(BookRepository bookRepository, ValidateBookTitle validateBookTitle) {
        this.bookRepository = bookRepository;
        this.validateBookTitle = validateBookTitle;
    }

    @Override
    public void AddBook(Books book) {

        validateBookTitle.ValidateBookTitle(book.getTitle());
        bookRepository.save(book);
    }
}
