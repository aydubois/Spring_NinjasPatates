package org.abr.audreybr.dao;

import org.abr.audreybr.entity.Chouille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChouilleRepository extends JpaRepository<Chouille, Integer> {

    Optional<Chouille> findById(Integer id);

    @Query(value = "select * from Chouille C inner join Location L on C.Id_Location = L.Id_Location inner join Person P on L.Id_Person_Host = P.Id_Person where P.Id_Person = :idUser",
            nativeQuery = true)
    List<Chouille> getChouilleListById_Person_Host(@Param("idUser") Integer id);

}
