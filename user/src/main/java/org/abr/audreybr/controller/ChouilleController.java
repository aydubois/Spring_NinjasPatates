package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.entity.Chouille;
import org.abr.audreybr.entity.Location;
import org.abr.audreybr.entity.Person;
import org.abr.audreybr.service.ChouilleService;
import org.abr.audreybr.service.LocationService;
import org.abr.audreybr.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/chouille")
public class ChouilleController {

    private final ChouilleService chouilleService;
    private final LocationService locationService;
    private final PersonService personService;
    public ChouilleController(ChouilleService chouilleService, LocationService locationService, PersonService personService) {
        this.chouilleService = chouilleService;
        this.locationService = locationService;
        this.personService = personService;
    }

    @GetMapping
    public List<Chouille> getAll() {
        return chouilleService.getAll();
    }

    @GetMapping("/{id}")
    public Chouille get(@PathVariable("id") Integer id) throws NotFoundException {
        return chouilleService.getChouille(id);
    }

   /* @PostMapping
    public Chouille create(@RequestBody Chouille chouille) {
        return chouilleService.create(chouille);
    }
*/
    @PutMapping(path = "{id}")
    public Chouille update(@PathVariable Integer id, @RequestBody Chouille chouille) throws NotFoundException {
        return chouilleService.editChouille(id,chouille);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws NotFoundException {
        return chouilleService.deleteChouille(id);
    }
    @PostMapping("/create/{id}")
    public RedirectView create(@PathVariable Integer id, @RequestParam String thematic, @RequestParam Date date, @RequestParam Integer location) throws NotFoundException {
        Location loc = locationService.getLocation(location);
        chouilleService.createBase(thematic, date, loc);


        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8082/myChouilles/" + id);
        return redirectView;
    }
    @PostMapping("/addperson/{id}")
    public RedirectView addPerson(@PathVariable Integer id, @RequestParam String code){
        chouilleService.addPerson(id, code);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8082/otherChouilles/" + id);
        return redirectView;
    }
    @PostMapping("/update/{id}")
    public RedirectView update(@PathVariable Integer id, @RequestParam String thematic, @RequestParam Date date, @RequestParam Integer location) throws NotFoundException {
        Location loc = locationService.getLocation(location);
        chouilleService.updateBase(id, thematic, date, loc);


        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8082/myChouilles/" + loc.getHost().getId_Person());
        return redirectView;
    }

    @GetMapping("/deleteguest/{id}/{id2}")
    public RedirectView deleteGuest(HttpServletRequest request, @PathVariable Integer id, @PathVariable Integer id2) throws NotFoundException {
        Chouille chouille = chouilleService.getChouille(id);
        Person guest = personService.getPerson(id2);
        chouilleService.deleteGuest(chouille, guest);

        String referer = request.getHeader("Referer");
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(referer);
        return redirectView;

    }
}
