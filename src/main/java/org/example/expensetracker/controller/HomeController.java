package org.example.expensetracker.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Expense Tracker";
    }

    @GetMapping("/users")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String pageForUsers() {
        return "You are logged in as user";
    }

    @GetMapping("/admins")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String pageForAdmins() {
        return "You are logged in as admmin";
    }
}
