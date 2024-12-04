package OnlineLibrary.ro.MyApiApp.Controllers;


import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import OnlineLibrary.ro.MyApiApp.Books.Services.BorrowBookService;
import OnlineLibrary.ro.MyApiApp.Books.Services.GetBookService;
import OnlineLibrary.ro.MyApiApp.Books.Services.ReturnBookService;
import OnlineLibrary.ro.MyApiApp.User.Classes.MyUser;
import OnlineLibrary.ro.MyApiApp.User.Services.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping()
public class UserController {

    private final RegisterUserService registerUserService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;
    private final ChangePasswordService changePasswordService;

    private final GetBookService getBookService;
    private final BorrowBookService borrowBookService;
    private final ReturnBookService returnBookService;

    public UserController(RegisterUserService registerUserService, UpdateUserService updateUserService, DeleteUserService deleteUserService, ChangePasswordService changePasswordService, GetBookService getBookService, BorrowBookService borrowBookService, ReturnBookService returnBookService) {
        this.registerUserService = registerUserService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
        this.changePasswordService = changePasswordService;
        this.getBookService = getBookService;
        this.borrowBookService = borrowBookService;
        this.returnBookService = returnBookService;
    }


    @GetMapping("path/home")
    public List<Books> getBooks()
    {
        return getBookService.getAllBooks();
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
}
