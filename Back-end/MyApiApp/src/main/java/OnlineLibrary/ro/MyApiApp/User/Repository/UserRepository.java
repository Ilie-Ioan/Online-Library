package OnlineLibrary.ro.MyApiApp.User.Repository;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByUsername(String username);
}
