package org.abr.audreybr.service;

import org.abr.audreybr.dao.PersonRepository;
import org.abr.audreybr.entity.Location;
import org.abr.audreybr.entity.Person;
import org.abr.audreybr.exception.BadRequestException;
import javassist.NotFoundException;
import org.abr.audreybr.dao.LocationRepository;
import org.abr.audreybr.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LocationService {

    @Autowired
    LocationRepository repository;
    @Autowired
    PersonRepository personRepository;
    public List<Location> getAll() {
        return repository.findAll();
    }

    public List<Location> getByHost(Integer id){
        Person host = personRepository.findById(id).get();
        return repository.findByHost(host);}

    public Location create(Location location) {
        if (location.getAdress() == null ||
                location.getMax_Pers() == null ||
                location.getHost() == null) {
            throw new BadRequestException("Input values can't be empty");
        }

        Location newLocation = new Location();

        newLocation.setAdress(location.getAdress());
        newLocation.setMax_Pers(location.getMax_Pers());
        newLocation.setHost(location.getHost());

        repository.save(newLocation);
        return newLocation;
    }

    public Location getLocation(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cette location n'existe pas"));
    }

    public Location editLocation(Integer id, Location location) throws NotFoundException {
        if (location.getId_Location() == null) {
            throw new BadRequestException("Input values can't be empty");
        }
        Location modifiedLocation = repository.findById(id).orElseThrow(() -> new NotFoundException("cette location n'existe pas"));

        modifiedLocation.setAdress(location.getAdress());
        modifiedLocation.setMax_Pers(location.getMax_Pers());
        modifiedLocation.setHost(location.getHost());

        repository.save(modifiedLocation);
        return modifiedLocation;
    }


    public ResponseEntity<String> deleteLocation(Integer id) throws NotFoundException {
        Location location = this.getLocation(id);
        repository.delete(location);
        return ResponseEntity.status(HttpStatus.OK).body("La location (" + location.getId_Location() + ") a bien été supprimé");
    }

    public Location updateLocation(Integer id_Location, String adress,Integer max_Pers) throws NotFoundException {
        Location modifiedLocation = repository.findById(id_Location).orElseThrow(() -> new NotFoundException("cette location n'existe pas"));

        modifiedLocation.setAdress(adress);
        modifiedLocation.setMax_Pers(max_Pers);
        repository.save(modifiedLocation);
        return modifiedLocation;
    }

}
