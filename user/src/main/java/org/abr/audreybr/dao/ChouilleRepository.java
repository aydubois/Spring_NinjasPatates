package org.abr.audreybr.dao;

import org.abr.audreybr.entity.Chouille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChouilleRepository extends JpaRepository<Chouille, Long> {

    public Optional<Chouille> findById(Long id);
  //  public List<Chouille> findByName(String name);
}
