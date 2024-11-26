package OnlineLibrary.ro.MyApiApp.User.Services;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;
import OnlineLibrary.ro.MyApiApp.User.Interfaces.IUpdateUserService;
import OnlineLibrary.ro.MyApiApp.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateUserService implements IUpdateUserService {

    private final UserRepository userRepository;
    private final ValidateEmailUser validateEmailUser;
    private final ValidateUsernameService validateUsernameService;

    public UpdateUserService(UserRepository userRepository, ValidateEmailUser validateEmailUser, ValidateUsernameService validateUsernameService) {
        this.userRepository = userRepository;
        this.validateEmailUser = validateEmailUser;
        this.validateUsernameService = validateUsernameService;
    }

    @Override
    public void updateUser(User user, UUID id) {
        User userUpdate = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("The user with the id %d was not found",id))
        );
        userUpdate.setUsername(user.getUsername());
        userUpdate.setEmail(user.getEmail());
        validateEmailUser.validateEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());
        validateUsernameService.validateUsername((user.getUsername()));

        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setPhoneNumber(user.getPhoneNumber());
        userUpdate.setAdress(user.getAdress());

        userRepository.save(userUpdate);


    }
}
