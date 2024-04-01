package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.Plate;
import fr.univamu.iut.apiplateuser.repository.PlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlatServiceImpl implements PlateService{

    private final PlateRepository plateRepository;

    @Autowired
    public PlatServiceImpl(PlateRepository plateRepository) {
        this.plateRepository = plateRepository;
    }

    @Override
    public ArrayList<Plate> getAllPlates() {
        return (ArrayList<Plate>) this.plateRepository.findAll();
    }

    @Override
    public Plate getPlateById(int id) {
        return this.plateRepository.findById(id).orElse(null);
    }

    @Override
    public Plate addPlate(Plate plate) {
        return this.plateRepository.save(plate);
    }

    @Override
    public Plate updatePlate(Plate plate) {
        return this.plateRepository.save(plate);
    }

    @Override
    public void deletePlate(int id) {
        this.plateRepository.deleteById(id);
    }
}
