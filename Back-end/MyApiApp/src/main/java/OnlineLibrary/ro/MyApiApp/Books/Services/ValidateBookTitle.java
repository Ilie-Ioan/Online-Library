package OnlineLibrary.ro.MyApiApp.Books.Services;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import OnlineLibrary.ro.MyApiApp.Books.Interfaces.IValidateBookTitle;
import OnlineLibrary.ro.MyApiApp.Books.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidateBookTitle implements IValidateBookTitle {

    private final BookRepository bookRepository;

    public ValidateBookTitle(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void ValidateBookTitle(String title) {
        Optional<Books>booksOptional = bookRepository.getBookByTitle(title);
        if(booksOptional.isPresent())
            {
                throw new IllegalStateException(String.format("The book  %s is already exists",title));
            }
        }

}
