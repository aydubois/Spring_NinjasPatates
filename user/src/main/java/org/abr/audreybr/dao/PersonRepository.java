package org.abr.audreybr.dao;

import org.abr.audreybr.entity.Chouille;
import org.abr.audreybr.entity.Item;
import org.abr.audreybr.entity.Location;
import org.abr.audreybr.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    public Optional<Person> findById(Integer id);
    public List<Person> findByName(String name);


}
