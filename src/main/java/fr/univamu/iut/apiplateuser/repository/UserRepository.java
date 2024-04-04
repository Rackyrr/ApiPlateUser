package fr.univamu.iut.apiplateuser.repository;

import fr.univamu.iut.apiplateuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{
    User findByUsername(String username);

}
