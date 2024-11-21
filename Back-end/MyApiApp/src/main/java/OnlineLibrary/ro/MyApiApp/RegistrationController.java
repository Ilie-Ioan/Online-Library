package OnlineLibrary.ro.MyApiApp;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private final MyUserRepository myUserRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(MyUserRepository myUserRepository, PasswordEncoder passwordEncoder) {
        this.myUserRepository = myUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register/myUser")
    public MyUser createmyUser(@RequestBody MyUser myUser)
    {

        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        return  myUserRepository.save(myUser);
    }

}
