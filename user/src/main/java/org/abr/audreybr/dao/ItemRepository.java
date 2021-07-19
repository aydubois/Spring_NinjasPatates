package org.abr.audreybr.dao;

import org.abr.audreybr.entity.Chouille;
import org.abr.audreybr.entity.Item;
import org.abr.audreybr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    public Optional<Item> findById(Long id);

}
