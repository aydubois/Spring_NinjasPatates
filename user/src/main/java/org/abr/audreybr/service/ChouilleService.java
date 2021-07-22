package org.abr.audreybr.service;

import org.abr.audreybr.dao.PersonRepository;
import org.abr.audreybr.entity.Person;
import org.abr.audreybr.exception.BadRequestException;
import javassist.NotFoundException;
import org.abr.audreybr.dao.ChouilleRepository;
import org.abr.audreybr.entity.Chouille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
 /*   public List<Chouille> getChouillesWhereIamInvited(Integer id) throws NotFoundException {
        return repository.getChouilleListByIdPerson(id);
    }*/

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
        return ResponseEntity.status(HttpStatus.OK).body("La chouille (" + chouille.getId_Chouille() + ") a bien été supprimé");
    }

    public List<Chouille> getChouilleListByIdPersonOrderedByDate(Integer id){
        return repository.getChouilleListByIdPersonOrderedByDate(id, 3);
    }

}
