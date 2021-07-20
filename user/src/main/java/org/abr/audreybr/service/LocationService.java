package org.abr.audreybr.service;

import org.abr.audreybr.exception.BadRequestException;
import javassist.NotFoundException;
import org.abr.audreybr.dao.LocationRepository;
import org.abr.audreybr.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationService {

    @Autowired
    LocationRepository repository;

    public List<Location> getAll() {
        return repository.findAll();
    }

    public Location getLocation(long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(()->new NotFoundException("Cette location n'existe pas"));
    }

    public Location editLocation(long id,Location location) throws NotFoundException{
        if(location.getId() == null ){
            throw new BadRequestException("Input values can't be empty");
        }
        Location modifiedLocation = repository.findById(id).orElseThrow(()->new NotFoundException("cette location n'existe pas"));
        modifiedLocation.setMax_Pers(location.getMax_Pers());
        modifiedLocation.setAdress(location.getAdress());

        repository.save(modifiedLocation);
        return modifiedLocation;
    }


    public ResponseEntity<String> deleteLocation(long id) throws NotFoundException {
        Location location = this.getLocation(id);
        repository.delete(location);
        return ResponseEntity.status(HttpStatus.OK).body("La location ("+location.getId()+") a bien été supprimé");
    }



}
