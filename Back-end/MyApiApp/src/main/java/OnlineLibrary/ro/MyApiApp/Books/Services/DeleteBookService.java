package OnlineLibrary.ro.MyApiApp.Books.Services;

import OnlineLibrary.ro.MyApiApp.Books.Interfaces.IDeleteBookService;
import OnlineLibrary.ro.MyApiApp.Books.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class DeleteBookService implements IDeleteBookService {

    private final BookRepository bookRepository;

    public DeleteBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void DeleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
