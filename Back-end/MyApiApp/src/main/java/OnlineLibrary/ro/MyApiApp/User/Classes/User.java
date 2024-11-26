package OnlineLibrary.ro.MyApiApp.User.Classes;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;






    private String username;
    private String email;
    private String password;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adresa> adress;


    public User() {
    }

    public User(String first_Name, String last_Name, String phone_number, List<Adresa> adress, String username, String email, String password) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = first_Name;
        this.lastName = last_Name;
        this.phoneNumber = phone_number;
        this.adress = adress;
    }

    public UUID getId() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Adresa> getAdress() {
        return adress;
    }

    public void setAdress(List<Adresa> adress) {
        this.adress = adress;
    }


}
