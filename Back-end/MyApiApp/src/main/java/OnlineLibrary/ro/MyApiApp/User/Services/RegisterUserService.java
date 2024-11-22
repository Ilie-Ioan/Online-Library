package OnlineLibrary.ro.MyApiApp.User.Services;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;
import OnlineLibrary.ro.MyApiApp.User.Interfaces.IRegisterUserService;
import OnlineLibrary.ro.MyApiApp.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements IRegisterUserService {

    private final UserRepository userRepository;
    private final ValidateEmailUser validateEmailUser;
    private final ValidateUsernameService validateUsernameService;

    public RegisterUserService(UserRepository userRepository, ValidateEmailUser validateEmailUser, ValidateUsernameService validateUsernameService) {
        this.userRepository = userRepository;
        this.validateEmailUser = validateEmailUser;
        this.validateUsernameService = validateUsernameService;
    }


    @Override
    public void registerUser(User user) {
        validateEmailUser.validateEmail(user.getEmail());
        validateUsernameService.validateUsername(user.getUsername());
        userRepository.save(user);

    }
}
