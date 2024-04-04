package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.Dish;
import java.util.ArrayList;

public interface DishService {
    public ArrayList<Dish> getAllPlates();
    public Dish getPlateById(int id);
    public Dish addPlate(Dish dish);
    public Dish updatePlate(Dish dish);
    public boolean deletePlate(int id);
}
