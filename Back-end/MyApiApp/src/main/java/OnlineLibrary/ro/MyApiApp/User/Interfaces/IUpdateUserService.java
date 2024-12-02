package OnlineLibrary.ro.MyApiApp.User.Interfaces;

import OnlineLibrary.ro.MyApiApp.User.Classes.MyUser;

import java.util.UUID;

public interface IUpdateUserService {
    void updateUser(MyUser user, UUID id);
}
