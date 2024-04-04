package fr.univamu.iut.apiplateuser.controller;

import com.google.gson.Gson;
import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getAllUsers() {
        return this.gson.toJson(this.userService.getAllUsers());
    }

    @GetMapping("{id}")
    public String getUserById(@PathVariable int id) {
        return this.gson.toJson(this.userService.getUserById(id));
    }

    @GetMapping("/username/{username}")
    public String getUserByUsername(@PathVariable String username) {
        return this.gson.toJson(this.userService.getUserByUsername(username));
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        return this.gson.toJson(this.userService.addUser(user));
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        return this.gson.toJson(this.userService.updateUser(user));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
    }
}
