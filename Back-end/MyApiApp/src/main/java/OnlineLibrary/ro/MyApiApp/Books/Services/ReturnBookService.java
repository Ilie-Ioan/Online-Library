package OnlineLibrary.ro.MyApiApp.Books.Services;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import OnlineLibrary.ro.MyApiApp.Books.Interfaces.IReturnBookService;
import OnlineLibrary.ro.MyApiApp.Books.Repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class ReturnBookService implements IReturnBookService {

    private final BookRepository bookRepository;

    public ReturnBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void ReturnBook(long id) {
        Books books = bookRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException(String.format("The book with the id %d was not found",id))
        );
        if(books.isStatus())
        {
            throw new IllegalStateException(String.format("The book with the id % was not borrowed",id));
        }

        books.setStatus(true);
        bookRepository.save(books);

    }
}
