package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Service interface for managing users.
 */
@Service
public interface UserService {

    /**
     * Retrieves all users.
     *
     * @return An ArrayList containing all users.
     */
    public ArrayList<User> getAllUsers();

    /**
     * Retrieves a user by its ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user with the specified ID, or null if not found.
     */
    public User getUserById(int id);

    /**
     * Retrieves a user by its username.
     *
     * @param username The username of the user to retrieve.
     * @return The user with the specified username, or null if not found.
     */
    public User getUserByUsername(String username);

    /**
     * Updates an existing user.
     *
     * @param user The user to update.
     * @return The updated user.
     */
    public User updateUser(User user);

    /**
     * Deletes a user by its ID.
     *
     * @param id The ID of the user to delete.
     * @return true if the user was successfully deleted, false otherwise.
     */
    public boolean deleteUser(int id);
}
