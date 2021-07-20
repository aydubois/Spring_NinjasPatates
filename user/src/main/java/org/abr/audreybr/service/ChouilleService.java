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

    public Chouille getChouille(long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(()->new NotFoundException("Cette chouille n'existe pas"));
    }

    public Chouille editChouille(long id,Chouille chouille) throws NotFoundException{
        if(chouille.getId() == null ){
            throw new BadRequestException("Input values can't be empty");
        }
        Chouille modifiedChouille = repository.findById(id).orElseThrow(()->new NotFoundException("cette chouille n'existe pas"));
        modifiedChouille.setThematic(chouille.getThematic());
        modifiedChouille.setDate(chouille.getDate());

        repository.save(modifiedChouille);
        return modifiedChouille;
    }


    public ResponseEntity<String> deleteChouille(long id) throws NotFoundException {
        Chouille chouille = this.getChouille(id);
        repository.delete(chouille);
        return ResponseEntity.status(HttpStatus.OK).body("La chouille ("+chouille.getId()+") a bien été supprimé");
    }



}
