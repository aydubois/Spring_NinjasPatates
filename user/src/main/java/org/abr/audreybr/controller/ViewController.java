package org.abr.audreybr.controller;

import org.abr.audreybr.entity.Person;
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
    private PersonService service;

    @GetMapping(path = "/profil")
    public String index(){
      /*  List<Person> users = service.getAll();
        model.addAttribute("users",users);
        model.addAttribute("newUser",new Person());*/
        return "profil";
    }
    @GetMapping(path = "/chouilles/mine")
    public String index2(){
      /*  List<Person> users = service.getAll();
        model.addAttribute("users",users);
        model.addAttribute("newUser",new Person());*/
        return "chouilles_mine";
    }
    @GetMapping(path = "/chouilles/other")
    public String index3(){
      /*  List<Person> users = service.getAll();
        model.addAttribute("users",users);
        model.addAttribute("newUser",new Person());*/
        return "chouilles_other";
    }
/*
    @DeleteMapping(path = "{id}")
    public String delete(@PathVariable("id") long id){
        service.deleteUser(id);
        return "redirect:/view";
    }

    @PostMapping()
    public String add(@ModelAttribute User user, Model model) {
        service.create(user);
        model.addAttribute("newUser", new User());
        return "login";
    }

    @PostMapping(path = "login")
    public String login(@ModelAttribute User user, Model model) {
        User authUser = service.login(user.getName());
        //RedirectView redirectView = new RedirectView();
        //redirectView.setUrl("http://localhost:8081/index/"+authUser.getId());
        model.addAttribute("user", authUser);
        return "profile";
    }

    @GetMapping(path = "login")
    public String loginView(@ModelAttribute User user,Model model) {
        model.addAttribute("newUser", new User());
        return "login";
    }

    @PutMapping(path = "{id}")
    public String edit(@PathVariable long id, @ModelAttribute User user) {
        service.editUser(id,user);
        return "redirect:/view/"+id;
    }

    @GetMapping("{id}")
    public String show(@PathVariable("id") int id, Model model){
        User user = service.getUser(id);
        model.addAttribute("user",user);
        return "profile";
    }*/

}