package ro.OnlineLibrary.MySpringApi;


import jakarta.persistence.Embeddable;

@Embeddable
public class UserPII {
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private String address;


    public UserPII() {
    }

    public UserPII(String first_name, String last_name, String phone, String email, String address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
