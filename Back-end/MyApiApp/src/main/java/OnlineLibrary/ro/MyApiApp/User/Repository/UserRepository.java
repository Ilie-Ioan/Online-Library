package OnlineLibrary.ro.MyApiApp.User.Repository;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
