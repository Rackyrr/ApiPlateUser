package fr.univamu.iut.apiplateuser.controller;

import com.google.gson.Gson;
import fr.univamu.iut.apiplateuser.entity.LoginCredentials;
import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> login(@RequestBody LoginCredentials loginCredentials) {
        User authenticatedUser = this.authService.authenticate(loginCredentials.getUsername(), loginCredentials.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(this.gson.toJson(authenticatedUser.readModel()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        User registeredUser = this.authService.register(user);
        if (registeredUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.gson.toJson(registeredUser.readModel()));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
        }
    }
}
