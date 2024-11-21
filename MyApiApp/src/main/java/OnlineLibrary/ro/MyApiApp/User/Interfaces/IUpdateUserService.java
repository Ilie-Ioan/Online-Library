package OnlineLibrary.ro.MyApiApp.User.Interfaces;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;

public interface IUpdateUserService {
    void updateUser(User user, long id);
}
