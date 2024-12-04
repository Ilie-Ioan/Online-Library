package OnlineLibrary.ro.MyApiApp.JWT.Interfaces;

import org.springframework.security.core.userdetails.UserDetails;

public interface IGenerateToken {
    String generateToken(UserDetails userDetails);
}
