package OnlineLibrary.ro.MyApiApp.User.Interfaces;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;

import java.util.UUID;

public interface IUpdateUserService {
    void updateUser(User user, UUID id);
}
