package OnlineLibrary.ro.MyApiApp.User.Services;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;
import OnlineLibrary.ro.MyApiApp.User.Interfaces.IValidateEmailUserService;
import OnlineLibrary.ro.MyApiApp.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ValidateEmailUser implements IValidateEmailUserService {

    private final UserRepository userRepository;

    public ValidateEmailUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateEmail(String email) {
        Optional<User> userOptional = userRepository.getUserByEmail(email);
        if(userOptional.isPresent())
        {
            throw new IllegalStateException(String.format("The email address %s is already used",email));
        }
    }
}
