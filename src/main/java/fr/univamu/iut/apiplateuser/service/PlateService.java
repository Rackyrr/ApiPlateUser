package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.Plate;
import java.util.ArrayList;

public interface PlateService {
    public ArrayList<Plate> getAllPlates();
    public Plate getPlateById(int id);
    public Plate addPlate(Plate plate);
    public Plate updatePlate(Plate plate);
    public void deletePlate(int id);
}
