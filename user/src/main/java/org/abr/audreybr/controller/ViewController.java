package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.entity.Chouille;
import org.abr.audreybr.entity.Location;
import org.abr.audreybr.entity.Person;
import org.abr.audreybr.service.ChouilleService;
import org.abr.audreybr.service.LocationService;

import org.abr.audreybr.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private PersonService servicePerson;
    @Autowired
    private LocationService serviceLocation;
    @Autowired
    private ChouilleService serviceChouille;

    @GetMapping(path = "/profil")
    public String index(Model model) throws NotFoundException {
        Person person = servicePerson.getPerson(1);
        model.addAttribute("person",person);
        /*TODO : Il faut aussi rajouter tous les lieux lié à la personne + 3 dernières chouilles passées */
        List<Location> locations = serviceLocation.getAll();
        model.addAttribute("locations", locations);
        List<Chouille> chouilles = serviceChouille.getAll();
        model.addAttribute("chouilles", chouilles);
        return "profil";
    }
    @PutMapping(path ="/location/put/{id}")
    public void test(@PathVariable long id){

    }

    @GetMapping(path = "/myChouilles/{id}")
    public String getMyChouilles(@PathVariable("id") int id, Model model) throws NotFoundException {
        List<Chouille> chouilles = serviceChouille.getMyChouilles(id);
        model.addAttribute("chouilles",chouilles);
        return "chouilles_mine";
    }

    @GetMapping(path = "/otherChouilles/{id}")
    public String getChouillesWhereIamInvited(@PathVariable("id") int id, Model model) throws NotFoundException {
        List<Chouille> chouilles = serviceChouille.getChouillesWhereIamInvited(id);
        model.addAttribute("chouilles",chouilles);
        return "chouilles_other";
    }


}
