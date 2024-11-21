package OnlineLibrary.ro.MyApiApp.User.Interfaces;

import OnlineLibrary.ro.MyApiApp.User.Classes.User;

import java.util.List;

public interface IShowUserService {
    List<User> getUsers();
}
