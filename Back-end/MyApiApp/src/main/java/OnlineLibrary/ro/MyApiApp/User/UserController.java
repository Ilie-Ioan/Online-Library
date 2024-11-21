package OnlineLibrary.ro.MyApiApp.User;


import OnlineLibrary.ro.MyApiApp.User.Classes.User;
import OnlineLibrary.ro.MyApiApp.User.Services.DeleteUserService;
import OnlineLibrary.ro.MyApiApp.User.Services.RegisterUserService;
import OnlineLibrary.ro.MyApiApp.User.Services.ShowAllUserService;
import OnlineLibrary.ro.MyApiApp.User.Services.UpdateUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final ShowAllUserService showAllUserService;
    private final RegisterUserService registerUserService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;

    public UserController(ShowAllUserService showAllUserService, RegisterUserService registerUserService, UpdateUserService updateUserService, DeleteUserService deleteUserService) {
        this.showAllUserService = showAllUserService;
        this.registerUserService = registerUserService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
    }

    @GetMapping
    public List<User> getUsers()
    {
        return showAllUserService.getUsers();
    }

    @PostMapping
    public void registerUser(@RequestBody User user)
    {
       registerUserService.registerUser(user);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@RequestBody User user, @PathVariable long id)
    {
        updateUserService.updateUser(user,id);
    }

    @DeleteMapping(path = "{id}")
    public  void deleteUser(@PathVariable long id)
    {
        deleteUserService.deleteUser(id);
    }
}
