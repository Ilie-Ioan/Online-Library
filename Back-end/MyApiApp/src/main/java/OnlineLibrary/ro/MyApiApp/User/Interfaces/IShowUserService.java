package OnlineLibrary.ro.MyApiApp.User.Interfaces;

import OnlineLibrary.ro.MyApiApp.User.Classes.MyUser;

import java.util.List;

public interface IShowUserService {
    List<MyUser> getUsers();
}
