package org.abr.audreybr.dao;

import org.abr.audreybr.entity.Chouille;
import org.abr.audreybr.entity.Item;

import org.abr.audreybr.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    public Optional<Item> findById(Integer id);

    public Optional<Item> getItemByPersonAndChouille(Person person, Chouille chouille);

}
