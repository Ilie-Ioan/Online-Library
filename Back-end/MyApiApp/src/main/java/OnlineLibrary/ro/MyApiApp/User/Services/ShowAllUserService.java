package OnlineLibrary.ro.MyApiApp.User.Services;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;
import OnlineLibrary.ro.MyApiApp.User.Interfaces.IShowUserService;
import OnlineLibrary.ro.MyApiApp.User.Repository.UserRepository;

import java.util.List;

public class ShowAllUserService implements IShowUserService {

    private final UserRepository userRepository;

    public ShowAllUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
