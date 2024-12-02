package OnlineLibrary.ro.MyApiApp.User.Classes;

import jakarta.persistence.*;

@Entity
public class Adresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String block;
    private String stairs;
    private String city;
    private String county;
    private String country;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private MyUser user;

    public Adresa() {}

    public Adresa(String street, String block, String stairs, String city, String county, String country, MyUser user) {
        this.street = street;
        this.block = block;
        this.stairs = stairs;
        this.city = city;
        this.county = county;
        this.country = country;
        this.user = user;
    }

    // Getteri și setteri

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStairs() {
        return stairs;
    }

    public void setStairs(String stairs) {
        this.stairs = stairs;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }
}
