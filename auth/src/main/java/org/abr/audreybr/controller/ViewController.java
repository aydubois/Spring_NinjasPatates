package org.abr.audreybr.controller;

import javassist.NotFoundException;

import org.abr.audreybr.entity.Person;
import org.abr.audreybr.entity.Session;
import org.abr.audreybr.service.PersonService;
import org.abr.audreybr.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Controller
public class ViewController {

    @Autowired
    PersonService personService;

    @Autowired
    SessionService sessionService;

    @GetMapping(path = "/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping(path = "/login")
    @ResponseBody
    public String login(HttpServletResponse response, @RequestParam String username, @RequestParam String password ) throws NotFoundException, IOException {
        if(username.isEmpty() || password.isEmpty()) return null;
        Person person = personService.findByUsername(username);
        if(person == null){
            return "user not found";
        }
        if(passwordEncoder().matches(password,person.getPassword()) ){
            Cookie cookie = new Cookie("sessionId","value");
            Session session = new Session();
            session.setId(cookie.getValue());
            session.setPerson_id(person);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.HOUR, 1);
            session.setValid_until(calendar.getTime());
            sessionService.create(session);
            response.addCookie(cookie);
            response.sendRedirect("http://localhost:8082/myChouilles/"+person.getId_Person());
        }

        return "profil";
    }

    @PutMapping(path ="/location/put/{id}")
    public void test(@PathVariable long id){

    }

    @GetMapping(path = "/myChouilles/{id}")
    public String getMyChouilles(@PathVariable("id") int id, Model model) throws NotFoundException {

        return "chouilles_mine";
    }

    @GetMapping(path = "/otherChouilles/{id}")
    public String getChouillesWhereIamInvited(@PathVariable("id") int id, Model model) throws NotFoundException {

        return "chouilles_other";
    }

    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
