package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.dto.PersonDTO;
import org.abr.audreybr.entity.Person;
import org.abr.audreybr.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/home")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable("id") long id) throws NotFoundException {
        return personService.getPerson(id);
    }


    @PutMapping(path = "{id}")
    public Person update(@PathVariable long id, @RequestBody Person person) throws NotFoundException {
        return personService.editPerson(id,person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) throws NotFoundException  {
        return personService.deletePerson(id);
    }


}