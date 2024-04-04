package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    @Override
    public User register(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        this.userRepository.save(user);
        return user;
    }
}
