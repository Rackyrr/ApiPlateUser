package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) this.userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public boolean deleteUser(int id) {
        this.userRepository.deleteById(id);
        return (this.userRepository.findById(id).isEmpty());
    }
}
