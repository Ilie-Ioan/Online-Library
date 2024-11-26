package OnlineLibrary.ro.MyApiApp.Books.Services;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import OnlineLibrary.ro.MyApiApp.Books.Interfaces.IGetBookService;
import OnlineLibrary.ro.MyApiApp.Books.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBookService implements IGetBookService {

    private final BookRepository bookRepository;

    public GetBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }
}
