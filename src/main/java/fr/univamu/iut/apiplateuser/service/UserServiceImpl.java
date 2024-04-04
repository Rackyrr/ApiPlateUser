package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Implementation of the UserService interface for managing users.
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * The repository for accessing user data.
     */
    private final UserRepository userRepository;

    /**
     * Constructs a new UserServiceImpl with the specified UserRepository.
     *
     * @param userRepository The repository for accessing user data.
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all users.
     *
     * @return An ArrayList containing all users.
     */
    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) this.userRepository.findAll();
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user with the specified ID, or null if not found.
     */
    @Override
    public User getUserById(int id) {
        return this.userRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves a user by its username.
     *
     * @param username The username of the user to retrieve.
     * @return The user with the specified username, or null if not found.
     */
    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    /**
     * Updates an existing user.
     *
     * @param user The user to update.
     * @return The updated user.
     */
    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id The ID of the user to delete.
     * @return true if the user was successfully deleted, false otherwise.
     */
    @Override
    public boolean deleteUser(int id) {
        this.userRepository.deleteById(id);
        return (this.userRepository.findById(id).isEmpty());
    }
}
