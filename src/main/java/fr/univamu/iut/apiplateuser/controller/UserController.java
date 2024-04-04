package fr.univamu.iut.apiplateuser.controller;

import com.google.gson.Gson;
import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling user-related operations.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * The service for managing users.
     */
    private final UserService userService;

    /**
     * Gson instance for JSON serialization/deserialization.
     */
    private final Gson gson;

    /**
     * Constructs a new UserController with the specified UserService.
     *
     * @param userService The service for managing users.
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        this.gson = new Gson();
    }

    /**
     * Retrieves all users.
     *
     * @return ResponseEntity with the JSON representation of all users.
     */
    @GetMapping("/all")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok(this.gson.toJson(this.userService.getAllUsers()));
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id The ID of the user to retrieve.
     * @return ResponseEntity with the JSON representation of the user if found, or an error message otherwise.
     */
    @GetMapping("{id}")
    public ResponseEntity<String> getUserById(@PathVariable int id) {
        User user = this.userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(this.gson.toJson(user));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    /**
     * Retrieves a user by its username.
     *
     * @param username The username of the user to retrieve.
     * @return ResponseEntity with the JSON representation of the user if found, or an error message otherwise.
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<String> getUserByUsername(@PathVariable String username) {
        User user = this.userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(this.gson.toJson(user));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    /**
     * Updates an existing user.
     *
     * @param user The updated user.
     * @return ResponseEntity with the JSON representation of the updated user if successful, or an error message otherwise.
     */
    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        User updatedUser = this.userService.updateUser(user);
        if (updatedUser != null) {
            return ResponseEntity.ok(this.gson.toJson(updatedUser));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id The ID of the user to delete.
     * @return ResponseEntity indicating success or failure of the deletion operation.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        boolean deleted = this.userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
