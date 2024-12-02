package OnlineLibrary.ro.MyApiApp.User.Services;

import OnlineLibrary.ro.MyApiApp.User.Interfaces.IDeleteUserService;
import OnlineLibrary.ro.MyApiApp.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteUserService implements IDeleteUserService {

    private final UserRepository userRepository;

    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
