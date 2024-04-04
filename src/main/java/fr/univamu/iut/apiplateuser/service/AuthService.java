package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    public User authenticate(String username, String password);
    public User register(User user);
}
