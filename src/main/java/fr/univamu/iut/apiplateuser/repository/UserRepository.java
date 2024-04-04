package fr.univamu.iut.apiplateuser.repository;

import fr.univamu.iut.apiplateuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing User entities.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Finds a user by username.
     *
     * @param username The username to search for.
     * @return The user with the specified username, or null if not found.
     */
    User findByUsername(String username);
}
