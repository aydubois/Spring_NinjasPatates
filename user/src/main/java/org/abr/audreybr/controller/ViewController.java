package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.dto.ChouilleDTO;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class ViewController {

    @Autowired
    private PersonService servicePerson;
    @Autowired
    private LocationService serviceLocation;
    @Autowired
    private ChouilleService serviceChouille;

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
        /*List<Chouille> chouilles = serviceChouille.getChouillesWhereIamInvited(id);
        model.addAttribute("chouilles",chouilles);
        */return "chouilles_other";
    }


}
