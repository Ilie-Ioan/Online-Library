package ro.OnlineLibrary.MySpringApi;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "user_id",allocationSize = 1)
    @GeneratedValue(generator = "user_id",strategy = GenerationType.SEQUENCE)
    private Long user_id;
    private String Username;
    private String Role;
    private String Password;
    @Embedded UserPII pii;

    public User(String username, String role, String password,UserPII pii) {
        Username = username;
        Role = role;
        Password = password;
        this.pii = pii;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User() {
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setRole(String role) {
        Role = role;
    }

    public void setPii(UserPII pii) {
        this.pii = pii;
    }

    public Long getId() {
        return user_id;
    }

    public String getUsername() {
        return Username;
    }

    public String getRole() {
        return Role;
    }

    public UserPII getPii() {
        return pii;
    }
}
