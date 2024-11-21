package OnlineLibrary.ro.MyApiApp.User.Classes;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "user_id_sequence",
            strategy =  GenerationType.SEQUENCE
    )
    private long id;

    private String username;
    private String email;
    private String password;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
