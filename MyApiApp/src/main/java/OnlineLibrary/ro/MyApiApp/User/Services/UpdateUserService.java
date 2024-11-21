package OnlineLibrary.ro.MyApiApp.User.Services;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;
import OnlineLibrary.ro.MyApiApp.User.Interfaces.IUpdateUserService;
import OnlineLibrary.ro.MyApiApp.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService implements IUpdateUserService {

    private final UserRepository userRepository;
    private final ValidateEmailUser validateEmailUser;

    public UpdateUserService(UserRepository userRepository, ValidateEmailUser validateEmailUser) {
        this.userRepository = userRepository;
        this.validateEmailUser = validateEmailUser;
    }

    @Override
    public void updateUser(User user, long id) {
        User userUpdate = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("The user with the id %d was not found",id))
        );
        userUpdate.setUsername(user.getUsername());
        userUpdate.setEmail(user.getEmail());
        validateEmailUser.validateEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());

        userRepository.save(userUpdate);


    }
}
