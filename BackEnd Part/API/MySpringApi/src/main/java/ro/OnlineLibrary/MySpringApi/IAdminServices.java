package ro.OnlineLibrary.MySpringApi;

import java.util.List;

public interface IAdminServices {
    List<User> getAllAdminS();
    void addBook(Book carte);
    void modifyBook(Book carte);
    void deleteBook(Long id_Carte);
    void addUser(User utilizator);
    void modifyUser(User utilizator,Long user_id);
    void deleteUser(Long user_id);
}
