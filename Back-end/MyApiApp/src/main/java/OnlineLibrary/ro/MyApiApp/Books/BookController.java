package OnlineLibrary.ro.MyApiApp.Books;


import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import OnlineLibrary.ro.MyApiApp.Books.Services.AddBookService;
import OnlineLibrary.ro.MyApiApp.Books.Services.GetBookService;
import OnlineLibrary.ro.MyApiApp.Books.Services.UpdateBookService;
import OnlineLibrary.ro.MyApiApp.Books.Services.DeleteBookService;
import OnlineLibrary.ro.MyApiApp.Books.Services.BorrowBookService;
import OnlineLibrary.ro.MyApiApp.Books.Services.ReturnBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/books")
public class BookController {

   private final GetBookService getBookService;
   private final AddBookService addBookService;
   private final UpdateBookService updateBookService;
   private final DeleteBookService deleteBookService;
   private final BorrowBookService borrowBookService;
   private final ReturnBookService returnBookService;


    public BookController(GetBookService getBookService, AddBookService addBookService, UpdateBookService updateBookService, DeleteBookService deleteBookService, BorrowBookService borrowBookService, ReturnBookService returnBookService) {
        this.getBookService = getBookService;
        this.addBookService = addBookService;
        this.updateBookService = updateBookService;
        this.deleteBookService = deleteBookService;
        this.borrowBookService = borrowBookService;
        this.returnBookService = returnBookService;
    }

    @GetMapping(path = "/home")
    public List<Books> getBooks()
    {
        return getBookService.getAllBooks();
    }

    @PostMapping(path = "/add")
    public void addBook(@RequestBody  Books book)
    {
        addBookService.AddBook(book);
    }

    @PutMapping(path = "{id}")
    public void updateBook(@RequestBody Books book ,@PathVariable UUID id)
    {
        updateBookService.UpdateBook(book,id);
    }

    @PutMapping(path = "{id}/borrow")
    public void borrowBook(@PathVariable UUID id)
    {
        borrowBookService.BorrowBook(id);
    }

    @PutMapping(path = "{id}/return")
    public void returnBook(@PathVariable UUID id)
    {
        returnBookService.ReturnBook(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBooks(@PathVariable UUID id)
    {
        deleteBookService.DeleteBook(id);
    }

}
