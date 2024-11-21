package OnlineLibrary.ro.MyApiApp.User.Repository;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByEmail(String email);
}
