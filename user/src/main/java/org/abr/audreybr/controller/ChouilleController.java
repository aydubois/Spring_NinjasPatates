package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.entity.Chouille;
import org.abr.audreybr.service.ChouilleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController
@RequestMapping("/chouille")
public class ChouilleController {

    private final ChouilleService chouilleService;

    public ChouilleController(ChouilleService chouilleService) {
        this.chouilleService = chouilleService;
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
    public RedirectView create(@PathVariable Integer id,@ModelAttribute Chouille chouille) {
        /*TODO : ne fonctionne pas pour le moment*/
        chouilleService.create(chouille);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8082/profil/" + id);
        return redirectView;
    }


}
