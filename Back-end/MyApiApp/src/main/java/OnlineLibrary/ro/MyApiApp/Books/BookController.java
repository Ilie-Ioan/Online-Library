package OnlineLibrary.ro.MyApiApp.Books;


import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import OnlineLibrary.ro.MyApiApp.Books.Interfaces.IGetBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/books")
public class BookController {

    private final IGetBookService iGetBookService;

    public BookController(IGetBookService iGetBookService) {
        this.iGetBookService = iGetBookService;
    }


    @GetMapping
    public List<Books> getAllBooks()
    {
        return iGetBookService.getAllBooks();
    }

}
