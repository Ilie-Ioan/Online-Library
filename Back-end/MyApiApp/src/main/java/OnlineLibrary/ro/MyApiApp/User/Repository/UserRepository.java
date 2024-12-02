package OnlineLibrary.ro.MyApiApp.User.Repository;

import OnlineLibrary.ro.MyApiApp.User.Classes.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<MyUser, UUID> {
    Optional<MyUser> getUserByEmail(String email);
    Optional<MyUser> getUserByUsername(String username);
}
