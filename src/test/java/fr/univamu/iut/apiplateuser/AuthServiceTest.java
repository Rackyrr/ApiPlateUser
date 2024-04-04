package fr.univamu.iut.apiplateuser;

import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.repository.UserRepository;
import fr.univamu.iut.apiplateuser.service.AuthService;
import fr.univamu.iut.apiplateuser.service.AuthServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    private AuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authService = new AuthServiceImpl(userRepository);
    }
    @Test
    void testRegisterUser() {
        User userToRegister = new User("nouvelUtilisateur", "0000", "emailemailemail@gmail.com", "rue du plombier");
        when(userRepository.save(any(User.class))).thenAnswer(i -> i.getArguments()[0]);

        User registeredUser = authService.register(userToRegister);

        assertNotNull(registeredUser);
        assertTrue(BCrypt.checkpw("0000", registeredUser.getPassword()));
    }

}
