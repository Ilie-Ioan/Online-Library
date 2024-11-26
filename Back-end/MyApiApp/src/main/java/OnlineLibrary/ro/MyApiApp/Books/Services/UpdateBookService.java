package OnlineLibrary.ro.MyApiApp.Books.Services;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import OnlineLibrary.ro.MyApiApp.Books.Interfaces.IUpdateBookService;
import OnlineLibrary.ro.MyApiApp.Books.Repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookService implements IUpdateBookService {
    private final BookRepository bookRepository;
    private final ValidateBookTitle validateBookTitle;
    public UpdateBookService(BookRepository bookRepository, ValidateBookTitle validateBookTitle) {
        this.bookRepository = bookRepository;
        this.validateBookTitle = validateBookTitle;
    }

    @Override
    public void UpdateBook(Books books, Long id) {
        Books bookUpdate = bookRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("The book with the id %d was not found",id))
        );
        bookUpdate.setTitle(books.getTitle());
        validateBookTitle.ValidateBookTitle(books.getTitle());
        bookUpdate.setAuthor(books.getAuthor());
        bookUpdate.setStatus(books.isStatus());
        bookUpdate.setYear(books.getYear());

        bookRepository.save(bookUpdate);
    }
}
