package OnlineLibrary.ro.MyApiApp.Controllers;


import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import OnlineLibrary.ro.MyApiApp.Books.Services.*;
import OnlineLibrary.ro.MyApiApp.User.Classes.MyUser;
import OnlineLibrary.ro.MyApiApp.User.Services.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

    private final ShowAllUserService showAllUserService;
    private final RegisterUserService registerUserService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;
    private final ChangePasswordService changePasswordService;

    private final GetBookService getBookService;
    private final AddBookService addBookService;
    private final UpdateBookService updateBookService;
    private final DeleteBookService deleteBookService;
    private final BorrowBookService borrowBookService;
    private final ReturnBookService returnBookService;

    public AdminController(ShowAllUserService showAllUserService, RegisterUserService registerUserService, UpdateUserService updateUserService, DeleteUserService deleteUserService, ChangePasswordService changePasswordService, GetBookService getBookService, AddBookService addBookService, UpdateBookService updateBookService, DeleteBookService deleteBookService, BorrowBookService borrowBookService, ReturnBookService returnBookService) {
        this.showAllUserService = showAllUserService;
        this.registerUserService = registerUserService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
        this.changePasswordService = changePasswordService;
        this.getBookService = getBookService;
        this.addBookService = addBookService;
        this.updateBookService = updateBookService;
        this.deleteBookService = deleteBookService;
        this.borrowBookService = borrowBookService;
        this.returnBookService = returnBookService;
    }

    @GetMapping(path = "/users")
    public List<MyUser> getUsers()
    {
        return showAllUserService.getUsers();
    }

    @PostMapping(path = "/register")
    public void registerUser(@RequestBody MyUser user)
    {
        registerUserService.registerUser(user);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@RequestBody MyUser user, @PathVariable UUID id)
    {
        updateUserService.updateUser(user,id);
    }

    @PutMapping(path = "{id}/change_password")
    public  void changePassword(@RequestBody MyUser user,@RequestParam String oldPassword,@RequestParam String newPassword){changePasswordService.ChangePassword(user,oldPassword,newPassword);}

    @DeleteMapping(path = "{id}")
    public  void deleteUser(@PathVariable UUID id)
    {
        deleteUserService.deleteUser(id);
    }


    @GetMapping(path = "/home")
    public List<Books> getBooks()
    {
        return getBookService.getAllBooks();
    }

    @PostMapping(path = "/book/add")
    public void addBook(@RequestBody  Books book)
    {
        addBookService.AddBook(book);
    }

    @PutMapping(path = "/book/{id}")
    public void updateBook(@RequestBody Books book ,@PathVariable UUID id)
    {
        updateBookService.UpdateBook(book,id);
    }

    @PutMapping(path = "/book/{id}/borrow")
    public void borrowBook(@PathVariable UUID id)
    {
        borrowBookService.BorrowBook(id);
    }

    @PutMapping(path = "/book/{id}/return")
    public void returnBook(@PathVariable UUID id)
    {
        returnBookService.ReturnBook(id);
    }

    @DeleteMapping(path = "/book/{id}")
    public void deleteBooks(@PathVariable UUID id)
    {
        deleteBookService.DeleteBook(id);
    }
}
