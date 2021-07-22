package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.entity.Chouille;
import org.abr.audreybr.entity.Location;
import org.abr.audreybr.service.ChouilleService;
import org.abr.audreybr.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("/chouille")
public class ChouilleController {

    private final ChouilleService chouilleService;
    private final LocationService locationService;
    public ChouilleController(ChouilleService chouilleService, LocationService locationService) {
        this.chouilleService = chouilleService;
        this.locationService = locationService;
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
        redirectView.setUrl("http://localhost:8082/mychouilles/" + id);
        return redirectView;
    }
    @PostMapping("/addperson/{id}")
    public RedirectView addPerson(@PathVariable Integer id, @RequestParam String code){
        chouilleService.addPerson(id, code);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8082/otherChouilles/" + id);
        return redirectView;
    }

}
