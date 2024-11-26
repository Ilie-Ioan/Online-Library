package OnlineLibrary.ro.MyApiApp.Books.Repository;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Books, UUID> {
    Optional<Books> getBookByTitle(String Title);

}
