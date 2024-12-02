package OnlineLibrary.ro.MyApiApp.User.Services;

import OnlineLibrary.ro.MyApiApp.User.Classes.MyUser;
import OnlineLibrary.ro.MyApiApp.User.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> userOptional = userRepository.getUserByUsername(username);
        if(userOptional.isPresent()){
            MyUser user = userOptional.get();
            return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles()
                    .build();

        }
        else{
            throw  new UsernameNotFoundException(username);

        }
    }
}
