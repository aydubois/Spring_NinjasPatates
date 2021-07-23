package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.dto.ChouilleDTO;
import org.abr.audreybr.entity.Chouille;
import org.abr.audreybr.entity.Item;
import org.abr.audreybr.entity.Location;
import org.abr.audreybr.entity.Person;
import org.abr.audreybr.service.ChouilleService;
import org.abr.audreybr.service.ItemService;
import org.abr.audreybr.service.LocationService;

import org.abr.audreybr.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ViewController {

    @Autowired
    private PersonService servicePerson;
    @Autowired
    private LocationService serviceLocation;
    @Autowired
    private ChouilleService serviceChouille;
    @Autowired
    private ItemService serviceItem;

    @GetMapping(path = "/profil/{id}")
    public String index(@PathVariable Integer id, Model model) throws NotFoundException {
        Person person = servicePerson.getPerson(id);
        model.addAttribute("person",person);
        List<Location> locations = serviceLocation.getByHost(id); //transform Optional => List
        /*model.addAttribute("test", locations.get(0));*/
        model.addAttribute("locations", locations);
        /*TODO : 3 dernières chouilles passées */

        List<Chouille> chouilles = serviceChouille.getChouilleListByIdPersonOrderedByDate(id);
        model.addAttribute("chouilles", chouilles);

        return "profil";
    }
    @PutMapping(path ="/location/put/{id}")
    public void test(@PathVariable long id){

    }

    @GetMapping(path = "/myChouilles/{id}")
    public String getMyChouilles(@PathVariable("id") int id, Model model) throws NotFoundException {
        // Add person into model
        Person person = servicePerson.getPerson(id);
        model.addAttribute("person",person);

        //add chouille with location into model
        List<Chouille> chouilles = serviceChouille.getMyChouillesInProgress(id);

        model.addAttribute("chouilles",chouilles);

        //add new chouille into model
        model.addAttribute("newChouille",new Chouille());

        //add locations into model
        List<Location> locations = serviceLocation.getByHost(id);
        model.addAttribute("locations", locations);
        return "chouilles_mine";
    }

    @GetMapping(path = "/otherChouilles/{id}")
    public String getChouillesWhereIamInvited(@PathVariable("id") int id, Model model) throws NotFoundException {
        Person person = servicePerson.getPerson(id);
        model.addAttribute("person",person);
        java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        List<Chouille> chouilles = serviceChouille.getChouillesByGuest(person).stream().filter(chouille -> {return chouille.getDate().compareTo(now) > 0 ;}).collect(Collectors.toList());
        model.addAttribute("chouilles",chouilles);

        return "chouilles_other";
    }

    @GetMapping("/stock/{id}/{id2}")
    public String getItemsByChouilleAndPerson(@PathVariable("id") Integer id, @PathVariable("id2") Integer id2, Model model) throws NotFoundException {
        Person person = servicePerson.getPerson(id);
        Chouille chouille = serviceChouille.getChouille(id2);
        List<Item> items = serviceItem.getItemByPersonAndChouille(person, chouille);
        model.addAttribute("items", items);
        model.addAttribute("chouille", chouille);
        model.addAttribute("person", person);
        return "update_item";
    }

}
