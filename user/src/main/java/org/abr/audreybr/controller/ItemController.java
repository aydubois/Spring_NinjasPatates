package org.abr.audreybr.controller;

import io.swagger.models.auth.In;
import javassist.NotFoundException;
import org.abr.audreybr.dto.ItemDTO;
import org.abr.audreybr.entity.Chouille;
import org.abr.audreybr.entity.Item;
import org.abr.audreybr.entity.Person;
import org.abr.audreybr.service.ChouilleService;
import org.abr.audreybr.service.ItemService;
import org.abr.audreybr.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final PersonService personService;
    private final ChouilleService chouilleService;

    public ItemController(ItemService itemService, PersonService personService, ChouilleService chouilleService) {
        this.itemService = itemService;
        this.personService = personService;
        this.chouilleService = chouilleService;
    }

    @GetMapping
    public List<Item> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable("id") Integer id) throws NotFoundException {
        return itemService.getItem(id);
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return itemService.create(item);
    }

    @PutMapping(path = "{id}")
    public Item update(@PathVariable Integer id, @RequestBody Item item) throws NotFoundException {
        return itemService.editItem(id,item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws NotFoundException {
        return itemService.deleteItem(id);
    }

    @PostMapping("/create/{id}")
    @ResponseBody
    public RedirectView createItem(@PathVariable Integer id, @RequestParam String type, @RequestParam Integer quantity, @RequestParam Integer measure, @RequestParam String unit, @RequestParam Integer id_Person, @RequestParam Integer id_Chouille) throws NotFoundException {
        Person person = personService.getPerson(id_Person);
        Chouille chouille = chouilleService.getChouille(id_Chouille);
        itemService.createBase(type, quantity, measure, unit, person, chouille);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8082/stock/" + id_Person + "/"+id_Chouille);
        return redirectView;
    }
}
