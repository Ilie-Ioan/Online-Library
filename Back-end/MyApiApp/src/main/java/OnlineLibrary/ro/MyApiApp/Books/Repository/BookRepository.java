package OnlineLibrary.ro.MyApiApp.Books.Repository;

import OnlineLibrary.ro.MyApiApp.Books.Classes.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books,Long> {
}
