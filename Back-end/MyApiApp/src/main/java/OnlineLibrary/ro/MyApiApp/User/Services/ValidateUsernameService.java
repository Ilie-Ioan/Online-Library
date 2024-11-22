package OnlineLibrary.ro.MyApiApp.User.Services;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;
import OnlineLibrary.ro.MyApiApp.User.Interfaces.IValidateUsernameService;
import OnlineLibrary.ro.MyApiApp.User.Repository.UserRepository;

import java.util.Optional;

public class ValidateUsernameService implements IValidateUsernameService {

    private final UserRepository userRepository;

    public ValidateUsernameService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateUsername(String username) {
        Optional<User> userOptional = userRepository.getUserByUsername(username);
        if(userOptional.isPresent())
        {
            throw new IllegalStateException(String.format("The username  %s is already used",username));
        }

    }
}
