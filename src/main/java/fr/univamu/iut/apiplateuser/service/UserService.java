package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserService {
    public ArrayList<User> getAllUsers();
    public User getUserById(int id);
    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(int id);
}