package ro.OnlineLibrary.MySpringApi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Book_Repository extends JpaRepository<User, Long> {
}
