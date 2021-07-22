package org.abr.audreybr.dao;

import org.abr.audreybr.entity.Location;
import org.abr.audreybr.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    public Optional<Location> findById(Integer id);

    @Query("select u from Location u where u.host = ?1")
    public List<Location> findByHost(Person host);
}
