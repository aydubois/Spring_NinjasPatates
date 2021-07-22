package org.abr.audreybr.service;

import org.abr.audreybr.entity.Person;
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
    public Person create(Person person) {
        if (person.getUsername() == null ) {
            throw new BadRequestException("Input values can't be empty");
        }

        Person newPerson = new Person();

        newPerson.setUsername(person.getUsername());

        repository.save(newPerson);
        return newPerson;
    }

    public Person getPerson(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(()->new NotFoundException("Cet utilisateur n'existe pas"));
    }

    public Person login(String name) throws NotFoundException {
        try {
            return repository.findByUsername(name).get(0);
        }catch (Exception e){
            throw new NotFoundException("Cet utilisateur n'existe pas");
        }
    }
    public Person editPerson(Integer id,Person person) throws NotFoundException{
        if(person.getUsername() == null || person.getUsername().isEmpty()){
            throw new BadRequestException("Input values can't be empty");
        }
        Person modifiedPerson = repository.findById(id).orElseThrow(()->new NotFoundException("ce client n'existe pas"));

        modifiedPerson.setUsername(person.getUsername());

        repository.save(modifiedPerson);
        return modifiedPerson;
    }


    public ResponseEntity<String> deletePerson(Integer id) throws NotFoundException {
        Person person = this.getPerson(id);
        repository.delete(person);
        return ResponseEntity.status(HttpStatus.OK).body("Le client ("+person.getUsername()+") a bien été supprimé");
    }



}
