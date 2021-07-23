package org.abr.audreybr.service;

import javassist.NotFoundException;
import org.abr.audreybr.dao.SessionRepository;
import org.abr.audreybr.entity.Person;
import org.abr.audreybr.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    SessionRepository repository;

    public Session getSession(String id) throws NotFoundException {
        return repository.findById(id).orElseThrow(()->new NotFoundException("Cette session n'existe pas"));
    }

    public void create(Session session){
        repository.save(session);
    }

}
