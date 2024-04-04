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

/**
 * Controller for handling user authentication and registration.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    /**
     * The service for handling authentication and registration.
     */
    private final AuthService authService;

    /**
     * Gson instance for JSON serialization/deserialization.
     */
    private final Gson gson;

    /**
     * Constructs a new AuthController with the specified AuthService.
     *
     * @param authService The service for handling authentication and registration.
     */
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
        this.gson = new Gson();
    }

    /**
     * Handles user login.
     *
     * @param loginCredentials The login credentials containing username and password.
     * @return ResponseEntity with the authenticated user data if successful, or an error message otherwise.
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginCredentials loginCredentials) {
        User authenticatedUser = this.authService.authenticate(loginCredentials.getUsername(), loginCredentials.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(this.gson.toJson(authenticatedUser.readModel()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    /**
     * Handles user registration.
     *
     * @param user The user to register.
     * @return ResponseEntity with the registered user data if successful, or an error message otherwise.
     */
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
