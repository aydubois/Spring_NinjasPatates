package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.dto.PersonDTO;
import org.abr.audreybr.entity.Person;
import org.abr.audreybr.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable("id") Integer id) throws NotFoundException {
        return personService.getPerson(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping(path = "{id}")
    public Person update(@PathVariable Integer id, @RequestBody Person person) throws NotFoundException {
        return personService.editPerson(id,person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws NotFoundException {
        return personService.deletePerson(id);
    }

}
