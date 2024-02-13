package src.Controller;

import com.sun.xml.bind.v2.runtime.reflect.Lister;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String redirectBasedOnRole() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("TEST");
        if (
                SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority(roles.get(0)))
                        && SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority(roles.get(1)))
                        && SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority(roles.get(2)))
        ) {
            return "redirect:/admin/dashboard";
        } else if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            return "redirect:/user/dashboard";
        } else {
            System.out.println("peos");
            System.out.println("failed");
            return "";
        }
    }
}
