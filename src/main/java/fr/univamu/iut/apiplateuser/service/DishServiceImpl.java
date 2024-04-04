package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.Dish;
import fr.univamu.iut.apiplateuser.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository plateRepository;

    @Autowired
    public DishServiceImpl(DishRepository plateRepository) {
        this.plateRepository = plateRepository;
    }

    @Override
    public ArrayList<Dish> getAllPlates() {
        return (ArrayList<Dish>) this.plateRepository.findAll();
    }

    @Override
    public Dish getPlateById(int id) {
        return this.plateRepository.findById(id).orElse(null);
    }

    @Override
    public Dish addPlate(Dish dish) {
        return this.plateRepository.save(dish);
    }

    @Override
    public Dish updatePlate(Dish dish) {
        return this.plateRepository.save(dish);
    }

    @Override
    public boolean deletePlate(int id) {
        this.plateRepository.deleteById(id);
        return (this.plateRepository.findById(id).isEmpty());
    }
}
