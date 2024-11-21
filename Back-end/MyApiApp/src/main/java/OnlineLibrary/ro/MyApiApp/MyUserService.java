package OnlineLibrary.ro.MyApiApp;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserService implements UserDetailsService {

    private final MyUserRepository MyUserRepository;

    public MyUserService(MyUserRepository MyUserRepository) {
        this.MyUserRepository = MyUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> MyUser = MyUserRepository.findByUsername(username);
        if (MyUser.isPresent()) {
            var MyUserObj = MyUser.get();
            return User.builder()
                    .username(MyUserObj.getUsername())
                    .password(MyUserObj.getPassword())
                    .roles(getRoles(MyUserObj))
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }

    private String[] getRoles(MyUser MyUser) {
        if (MyUser.getRole() == null) {
            return new String[]{"USER"};
        }
        return MyUser.getRole().split(",");
    }
}
