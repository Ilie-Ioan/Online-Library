package OnlineLibrary.ro.MyApiApp.User.Interfaces;

import OnlineLibrary.ro.MyApiApp.User.Classes.MyUser;

public interface IChangePassword {
    void ChangePassword(MyUser user, String oldPassword, String newPassord);
}
