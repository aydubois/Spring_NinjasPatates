package org.abr.audreybr.service;

import org.abr.audreybr.dao.SessionRepository;
import org.abr.audreybr.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    SessionRepository repository;

    public void create(Session session){
        repository.save(session);
    }

}
