package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.dto.PersonDTO;
import org.abr.audreybr.entity.Person;
import org.abr.audreybr.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService servicePerson;

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

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

/*    @PutMapping(path = "{id}")
    public Person update(@PathVariable Integer id, @RequestBody Person person) throws NotFoundException {
        return personService.editPerson(id,person);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws NotFoundException {
        return personService.deletePerson(id);
    }

    @PostMapping("/put/{id}")
    public RedirectView updateName(@PathVariable("id") Integer id, @ModelAttribute Person person) throws NotFoundException {

        Person updatedPerson = personService.editPerson(person.getId_Person(), person);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8082/profil/" + id);
        return redirectView;

    }

}
