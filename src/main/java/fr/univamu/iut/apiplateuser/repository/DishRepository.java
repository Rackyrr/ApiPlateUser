package fr.univamu.iut.apiplateuser.repository;

import fr.univamu.iut.apiplateuser.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {
}
