package org.abr.audreybr.service;

import org.abr.audreybr.exception.BadRequestException;
import javassist.NotFoundException;
import org.abr.audreybr.dao.PersonRepository;
import org.abr.audreybr.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> getAll() {
        return repository.findAll();
    }

    public Person getPerson(long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(()->new NotFoundException("Cet utilisateur n'existe pas"));
    }

    public Person login(String name) throws NotFoundException {
        try {
            return repository.findByName(name).get(0);
        }catch (Exception e){
            throw new NotFoundException("Cet utilisateur n'existe pas");
        }
    }
    public Person editPerson(long id,Person person) throws NotFoundException{
        if(person.getName() == null || person.getName().isEmpty()){
            throw new BadRequestException("Input values can't be empty");
        }
        Person modifiedPerson = repository.findById(id).orElseThrow(()->new NotFoundException("ce client n'existe pas"));
        modifiedPerson.setName(person.getName());

        repository.save(modifiedPerson);
        return modifiedPerson;
    }


    public ResponseEntity<String> deletePerson(long id) throws NotFoundException {
        Person person = this.getPerson(id);
        repository.delete(person);
        return ResponseEntity.status(HttpStatus.OK).body("Le client ("+person.getName()+") a bien été supprimé");
    }



}
