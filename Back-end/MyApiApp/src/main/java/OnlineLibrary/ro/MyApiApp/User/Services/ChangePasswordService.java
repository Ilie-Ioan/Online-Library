package OnlineLibrary.ro.MyApiApp.User.Services;

import OnlineLibrary.ro.MyApiApp.User.Classes.MyUser;
import OnlineLibrary.ro.MyApiApp.User.Interfaces.IChangePassword;
import OnlineLibrary.ro.MyApiApp.User.Repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ChangePasswordService implements IChangePassword {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ChangePasswordService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void ChangePassword(MyUser user, String oldPassword, String newPassword) {
        if(passwordEncoder.matches(oldPassword,user.getPassword()))
        {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        }

    }
}
