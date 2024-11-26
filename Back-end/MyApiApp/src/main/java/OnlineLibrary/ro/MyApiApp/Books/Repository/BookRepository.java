package OnlineLibrary.ro.MyApiApp.Books.Repository;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Books,Long> {
    Optional<Books> getBookByTitle(String Title);

}
