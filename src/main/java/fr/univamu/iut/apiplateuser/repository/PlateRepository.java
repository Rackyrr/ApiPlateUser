package fr.univamu.iut.apiplateuser.repository;

import fr.univamu.iut.apiplateuser.entity.Plate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlateRepository extends CrudRepository<Plate, Integer> {
}
