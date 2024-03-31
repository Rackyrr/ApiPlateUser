package fr.univamu.iut.apiplateuser.controller;

import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllUsers() {
        return this.userService.getAllUsers().toString();
    }

    @GetMapping("{id}")
    public String getUserById(@PathVariable int id) {
        return this.userService.getUserById(id).toString();
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        return this.userService.addUser(user).toString();
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        return this.userService.updateUser(user).toString();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
    }
}
