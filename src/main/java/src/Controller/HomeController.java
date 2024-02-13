package src.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String publicHome() {
        return "login";
    }


//    @GetMapping("/user/dashboard")
//    @PreAuthorize("hasRole('USER2')")
//    public String userDashboard() {
//        return "user";
//    }

//    @GetMapping("/admin/dashboard")
//    @PreAuthorize("hasRole('ADMIN2')")
//    public String adminDashboard() {
//        return "admin";
//    }

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('USER,ADMIN,TEST')")
    public String adminDashboard() {
        return "USER";
    }

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('USER,ADMIN')")
    public String admin() {
        return "admin";
    }
}
