package org.abr.audreybr.dao;

import org.abr.audreybr.entity.Item;
import org.abr.audreybr.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    public Optional<Location> findById(Long id);

}
