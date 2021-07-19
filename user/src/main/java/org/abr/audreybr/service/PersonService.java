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
}
