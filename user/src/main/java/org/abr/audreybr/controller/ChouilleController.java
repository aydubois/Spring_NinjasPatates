package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.entity.Chouille;
import org.abr.audreybr.service.ChouilleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/chouille")
public class ChouilleController {

    private final ChouilleService chouilleService;

    public ChouilleController(ChouilleService chouilleService) {
        this.chouilleService = chouilleService;
    }

    @GetMapping("/{id}")
    public Chouille get(@PathVariable("id") long id) throws NotFoundException {
        return chouilleService.getChouille(id);
    }


    @PutMapping(path = "{id}")
    public Chouille update(@PathVariable long id, @RequestBody Chouille chouille) throws NotFoundException {
        return chouilleService.editChouille(id,chouille);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) throws NotFoundException  {
        return chouilleService.deleteChouille(id);
    }


}
