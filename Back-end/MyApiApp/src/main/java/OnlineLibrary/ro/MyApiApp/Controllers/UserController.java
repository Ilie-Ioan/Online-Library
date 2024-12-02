package OnlineLibrary.ro.MyApiApp.Controllers;


import OnlineLibrary.ro.MyApiApp.User.Classes.MyUser;
import OnlineLibrary.ro.MyApiApp.User.Services.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final ShowAllUserService showAllUserService;
    private final RegisterUserService registerUserService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;
    private final ChangePasswordService changePasswordService;

    public UserController(ShowAllUserService showAllUserService, RegisterUserService registerUserService, UpdateUserService updateUserService, DeleteUserService deleteUserService, ChangePasswordService changePasswordService) {
        this.showAllUserService = showAllUserService;
        this.registerUserService = registerUserService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
        this.changePasswordService = changePasswordService;
    }

    @GetMapping
    public List<MyUser> getUsers()
    {
        return showAllUserService.getUsers();
    }

    @PostMapping(path = "/register")
        public void registerUser(@RequestBody MyUser user)
    {
       registerUserService.registerUser(user);
    }

    @PutMapping(path = "user/update/{id}")
    public void updateUser(@RequestBody MyUser user, @PathVariable UUID id)
    {
        updateUserService.updateUser(user,id);
    }

    @PutMapping
    public  void changePassword(@RequestBody MyUser user,@RequestParam String oldPassword,@RequestParam String newPassword){changePasswordService.ChangePassword(user,oldPassword,newPassword);}

    @DeleteMapping(path = "{id}")
    public  void deleteUser(@PathVariable UUID id)
    {
        deleteUserService.deleteUser(id);
    }
}
