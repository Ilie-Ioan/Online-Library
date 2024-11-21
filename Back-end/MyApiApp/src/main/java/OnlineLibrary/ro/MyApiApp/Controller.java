package OnlineLibrary.ro.MyApiApp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String handleWelcome()
    {
        return "Home";
    }

    @GetMapping("/admin/home")
    public String Admin_Home()
    {
        return "Home Admin";
    }

    @GetMapping("/customer/home")
    public String Customer_Home()
    {
        return "Home Customer";
    }
}
