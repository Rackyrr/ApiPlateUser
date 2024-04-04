package fr.univamu.iut.apiplateuser.controller;

import com.google.gson.Gson;
import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final Gson gson;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        this.gson = new Gson();
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok(this.gson.toJson(this.userService.getAllUsers()));
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getUserById(@PathVariable int id) {
        User user = this.userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(this.gson.toJson(user));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<String> getUserByUsername(@PathVariable String username) {
        User user = this.userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(this.gson.toJson(user));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        User updatedUser = this.userService.updateUser(user);
        if (updatedUser != null) {
            return ResponseEntity.ok(this.gson.toJson(updatedUser));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

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
