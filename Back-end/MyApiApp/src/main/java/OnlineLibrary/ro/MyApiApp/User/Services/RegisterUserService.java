package OnlineLibrary.ro.MyApiApp.User.Services;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;
import OnlineLibrary.ro.MyApiApp.User.Interfaces.IRegisterUserService;
import OnlineLibrary.ro.MyApiApp.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements IRegisterUserService {

    private final UserRepository userRepository;
    private final ValidateEmailUser validateEmailUser;

    public RegisterUserService(UserRepository userRepository, ValidateEmailUser validateEmailUser) {
        this.userRepository = userRepository;
        this.validateEmailUser = validateEmailUser;
    }


    @Override
    public void registerUser(User user) {
        validateEmailUser.validateEmail(user.getEmail());
        userRepository.save(user);

    }
}
