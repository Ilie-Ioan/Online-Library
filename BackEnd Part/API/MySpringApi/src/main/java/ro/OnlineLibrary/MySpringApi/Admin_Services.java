package ro.OnlineLibrary.MySpringApi;

import java.util.List;

public class Admin_Services implements IAdminServices{
    @Override
    public List<User> getAllAdminS() {
        return List.of();
    }

    @Override
    public void addBook(Book carte) {

    }

    @Override
    public void modifyBook(Book carte) {

    }

    @Override
    public void deleteBook(Long id_Carte) {

    }

    @Override
    public void addUser(User utilizator) {

    }

    @Override
    public void modifyUser(User utilizator, Long user_id) {

    }

    @Override
    public void deleteUser(Long user_id) {

    }
}
