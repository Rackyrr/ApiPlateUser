package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.User;
import org.springframework.stereotype.Service;

/**
 * Service interface for authentication and user registration.
 */
@Service
public interface AuthService {

    /**
     * Authenticates a user with the provided username and password.
     *
     * @param username The username of the user to authenticate.
     * @param password The password of the user to authenticate.
     * @return The authenticated user, or null if authentication fails.
     */
    User authenticate(String username, String password);

    /**
     * Registers a new user.
     *
     * @param user The user to register.
     * @return The registered user.
     */
    User register(User user);
}
