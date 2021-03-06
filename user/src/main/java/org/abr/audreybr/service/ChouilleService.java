package org.abr.audreybr.service;

import org.abr.audreybr.dao.PersonRepository;
import org.abr.audreybr.entity.Location;
import org.abr.audreybr.entity.Person;
import org.abr.audreybr.exception.BadRequestException;
import javassist.NotFoundException;
import org.abr.audreybr.dao.ChouilleRepository;
import org.abr.audreybr.entity.Chouille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class ChouilleService {

    @Autowired
    ChouilleRepository repository;

    @Autowired
    PersonRepository personRepository;

    public List<Chouille> getAll() {
        return repository.findAll();
    }

    public Chouille create(Chouille chouille) {
        if (chouille.getThematic() == null || chouille.getThematic().isEmpty() ||
                chouille.getDate() == null ||
                chouille.getLocation() == null ||
                chouille.getSam() == null ||
                chouille.getBouncer() == null) {
            throw new BadRequestException("Input values can't be empty");
        }

        Chouille newChouille = new Chouille();

        newChouille.setThematic(chouille.getThematic());
        newChouille.setDate(chouille.getDate());
        newChouille.setLocation(chouille.getLocation());
        newChouille.setSam(chouille.getSam());
        newChouille.setBouncer(chouille.getBouncer());
        newChouille.setCode(chouille.getCode());

        repository.save(newChouille);
        return newChouille;
    }
    public Chouille createBase(String thematic, java.sql.Date date, Location location){
        if (thematic == null || thematic.isEmpty() ||
                date == null ||
                location == null ) {
            throw new BadRequestException("Input values can't be empty");
        }

        Chouille newChouille = new Chouille();

        newChouille.setThematic(thematic);
        newChouille.setDate(date);

        newChouille.setLocation(location);
        newChouille.setCode(this.createCode());
        try{

        repository.save(newChouille);
        }catch(Exception e){
            System.out.println("PATATATATATATE");
            System.out.println(e.getMessage());
        }
        return newChouille;
    }
    public Chouille updateBase(Integer id, String thematic, java.sql.Date date, Location location){
        if (id == null ||thematic == null || thematic.isEmpty() ||
                date == null ||
                location == null ) {
            throw new BadRequestException("Input values can't be empty");
        }

        Chouille newChouille = repository.getOne(id);

        newChouille.setThematic(thematic);
        newChouille.setDate(date);

        newChouille.setLocation(location);
        try{
            repository.save(newChouille);
        }catch(Exception e){
            System.out.println("PATATATATATATE");
            System.out.println(e.getMessage());
        }
        return newChouille;
    }
    public Chouille getChouille(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cette chouille n'existe pas"));
    }

    public List<Chouille> getMyChouilles(Integer id) throws NotFoundException {
        Person host = personRepository.findById(id).get();
        return repository.getChouilleListByLocationHost(host);
    }

    public List<Chouille> getMyChouillesInProgress(Integer id) throws NotFoundException {
        /*Person host = personRepository.findById(id).get();*/
        return repository.getChouilleListByLocationHostAndDate(id, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
    }
    public List<Chouille> getChouillesByGuest(Person guest) throws NotFoundException {
        return repository.getChouillesByGuests(guest);
    }

    public Chouille editChouille(Integer id, Chouille chouille) throws NotFoundException {
        if (chouille.getId_Chouille() == null) {
            throw new BadRequestException("Input values can't be empty");
        }
        Chouille modifiedChouille = repository.findById(id).orElseThrow(() -> new NotFoundException("cette chouille n'existe pas"));

        modifiedChouille.setThematic(chouille.getThematic());
        modifiedChouille.setDate(chouille.getDate());
        modifiedChouille.setLocation(chouille.getLocation());
        modifiedChouille.setSam(chouille.getSam());
        modifiedChouille.setBouncer(chouille.getBouncer());
        modifiedChouille.setCode(chouille.getCode());

        repository.save(modifiedChouille);
        return modifiedChouille;
    }


    public ResponseEntity<String> deleteChouille(Integer id) throws NotFoundException {
        Chouille chouille = this.getChouille(id);
        repository.delete(chouille);
        return ResponseEntity.status(HttpStatus.OK).body("La chouille (" + chouille.getId_Chouille() + ") a bien ??t?? supprim??");
    }

    public List<Chouille> getChouilleListByIdPersonOrderedByDate(Integer id){
        return repository.getChouilleListByIdPersonOrderedByDate(id, 3);
    }

    public void addPerson(Integer id_Person,String code){
        Chouille chouille = repository.getChouilleByCode(code);
        Person guest = personRepository.getOne(id_Person);
        chouille.addGuest(guest);
        repository.save(chouille);
    }

    public void deleteGuest(Chouille chouille, Person guest){
        chouille.deleteGuest(guest);
        repository.save(chouille);
    }

    private String createCode(){
        String[] letters = {"A","B", "C","D","E","F","G","H","J","K","L","M","N","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] numbers = {"1","2","3","4","5","6","7","8","9"};
        String value = letters[(int)(Math.random() * ((letters.length - 0) + 1))]+letters[(int)(Math.random() * ((letters.length - 0) + 1))]+letters[(int)(Math.random() * ((letters.length - 0) + 1))]+numbers[(int)(Math.random() * ((numbers.length - 0) + 1))]+numbers[(int)(Math.random() * ((numbers.length - 0) + 1))]+letters[(int)(Math.random() * ((letters.length - 0) + 1))];
        return value;
    }
}
