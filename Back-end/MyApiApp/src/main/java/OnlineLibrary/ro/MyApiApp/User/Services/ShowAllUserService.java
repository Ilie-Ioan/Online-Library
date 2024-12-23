package OnlineLibrary.ro.MyApiApp.User.Services;

import OnlineLibrary.ro.MyApiApp.User.Classes.MyUser;
import OnlineLibrary.ro.MyApiApp.User.Interfaces.IShowUserService;
import OnlineLibrary.ro.MyApiApp.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowAllUserService implements IShowUserService {

    private final UserRepository userRepository;

    public ShowAllUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<MyUser> getUsers() {
        return userRepository.findAll();
    }
}
