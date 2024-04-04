package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the AuthService interface for authentication and user registration.
 */
@Service
public class AuthServiceImpl implements AuthService {

    /**
     * The repository for accessing user data.
     */
    private final UserRepository userRepository;

    /**
     * Constructs a new AuthServiceImpl with the specified UserRepository.
     *
     * @param userRepository The repository for accessing user data.
     */
    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Authenticates a user with the provided username and password.
     *
     * @param username The username of the user to authenticate.
     * @param password The password of the user to authenticate.
     * @return The authenticated user, or null if authentication fails.
     */
    @Override
    public User authenticate(String username, String password) {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }
        if (BCrypt.checkpw(password, user.getPassword())){
            return user;
        }
        return null;
    }

    /**
     * Registers a new user.
     *
     * @param user The user to register.
     * @return The registered user.
     */
    @Override
    public User register(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        this.userRepository.save(user);
        return user;
    }
}
