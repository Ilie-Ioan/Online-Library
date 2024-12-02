package OnlineLibrary.ro.MyApiApp.User.Services;

import OnlineLibrary.ro.MyApiApp.User.Classes.MyUser;
import OnlineLibrary.ro.MyApiApp.User.Interfaces.IRegisterUserService;
import OnlineLibrary.ro.MyApiApp.User.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class  RegisterUserService implements IRegisterUserService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ValidateEmailUser validateEmailUser;
    private final ValidateUsernameService validateUsernameService;

    public RegisterUserService(PasswordEncoder passwordEncoder, UserRepository userRepository, ValidateEmailUser validateEmailUser, ValidateUsernameService validateUsernameService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.validateEmailUser = validateEmailUser;
        this.validateUsernameService = validateUsernameService;
    }


    @Override
    public void registerUser(MyUser user) {
        validateEmailUser.validateEmail(user.getEmail());
        validateUsernameService.validateUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }
}
