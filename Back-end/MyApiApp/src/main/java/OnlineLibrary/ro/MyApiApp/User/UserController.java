package OnlineLibrary.ro.MyApiApp.User;


import OnlineLibrary.ro.MyApiApp.User.Classes.User;
import OnlineLibrary.ro.MyApiApp.User.Services.ShowAllUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final ShowAllUserService showAllUserService;

    public UserController(ShowAllUserService showAllUserService) {
        this.showAllUserService = showAllUserService;
    }

    @GetMapping
    public List<User> getUsers()
    {
        return showAllUserService.getUsers();
    }
}
