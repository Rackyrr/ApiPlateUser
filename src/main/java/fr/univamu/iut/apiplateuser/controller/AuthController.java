package fr.univamu.iut.apiplateuser.controller;

import com.google.gson.Gson;
import fr.univamu.iut.apiplateuser.entity.LoginCredentials;
import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final Gson gson;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
        this.gson = new Gson();
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginCredentials loginCredentials) {
        return this.gson.toJson(this.authService.authenticate(loginCredentials.getUsername(), loginCredentials.getPassword()));
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return this.gson.toJson(this.authService.register(user));
    }
}
