package org.abr.audreybr.dao;

import org.abr.audreybr.entity.Person;
import org.abr.audreybr.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

    public Optional<Session> findById(String id);
    //public Person findByPerson_Id(int id);
}
