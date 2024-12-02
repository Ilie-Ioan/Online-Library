package OnlineLibrary.ro.MyApiApp.Books.Services;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import OnlineLibrary.ro.MyApiApp.Books.Interfaces.IBorrowBookService;
import OnlineLibrary.ro.MyApiApp.Books.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BorrowBookService implements IBorrowBookService {

    private final BookRepository bookRepository;

    public BorrowBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void BorrowBook(UUID id) {
        Books books = bookRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException(String.format("The book with the id %d was not found",id))
        );
        if(!books.isStatus())
        {
            throw new IllegalStateException(String.format("The book with the id %d was not returned",id));
        }

        books.setStatus(false);
        bookRepository.save(books);

    }
}
