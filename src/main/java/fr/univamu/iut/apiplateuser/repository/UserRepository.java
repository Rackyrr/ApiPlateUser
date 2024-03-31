package fr.univamu.iut.apiplateuser.repository;

import fr.univamu.iut.apiplateuser.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Integer>{

}
