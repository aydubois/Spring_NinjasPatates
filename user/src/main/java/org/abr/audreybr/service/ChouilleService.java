package org.abr.audreybr.service;

import org.abr.audreybr.exception.BadRequestException;
import javassist.NotFoundException;
import org.abr.audreybr.dao.ChouilleRepository;
import org.abr.audreybr.entity.Chouille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChouilleService {

    @Autowired
    ChouilleRepository repository;

    public List<Chouille> getAll() {
        return repository.findAll();
    }

    public Chouille create(Chouille chouille) {
        if (chouille.getThematic() == null || chouille.getThematic().isEmpty() ||
                chouille.getDate() == null ||
                chouille.getId_Location() == null ||
                chouille.getId_Person_Sam() == null ||
                chouille.getId_Person_Bouncer() == null) {
            throw new BadRequestException("Input values can't be empty");
        }

        Chouille newChouille = new Chouille();

        newChouille.setThematic(chouille.getThematic());
        newChouille.setDate(chouille.getDate());
        newChouille.setId_Location(chouille.getId_Location());
        newChouille.setId_Person_Sam(chouille.getId_Person_Sam());
        newChouille.setId_Person_Bouncer(chouille.getId_Person_Bouncer());
        newChouille.setCode(chouille.getCode());

        repository.save(newChouille);
        return newChouille;
    }

    public Chouille getChouille(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cette chouille n'existe pas"));
    }

    public List<Chouille> getMyChouille(Integer id) throws NotFoundException {
        return repository.getChouilleListById_Person_Host(id);
    }



    public Chouille editChouille(Integer id, Chouille chouille) throws NotFoundException {
        if (chouille.getId_Chouille() == null) {
            throw new BadRequestException("Input values can't be empty");
        }
        Chouille modifiedChouille = repository.findById(id).orElseThrow(() -> new NotFoundException("cette chouille n'existe pas"));

        modifiedChouille.setThematic(chouille.getThematic());
        modifiedChouille.setDate(chouille.getDate());
        modifiedChouille.setId_Location(chouille.getId_Location());
        modifiedChouille.setId_Person_Sam(chouille.getId_Person_Sam());
        modifiedChouille.setId_Person_Bouncer(chouille.getId_Person_Bouncer());
        modifiedChouille.setCode(chouille.getCode());

        repository.save(modifiedChouille);
        return modifiedChouille;
    }


    public ResponseEntity<String> deleteChouille(Integer id) throws NotFoundException {
        Chouille chouille = this.getChouille(id);
        repository.delete(chouille);
        return ResponseEntity.status(HttpStatus.OK).body("La chouille (" + chouille.getId_Chouille() + ") a bien été supprimé");
    }


}
