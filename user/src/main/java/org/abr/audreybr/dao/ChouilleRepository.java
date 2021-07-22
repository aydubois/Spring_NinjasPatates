package org.abr.audreybr.dao;

import org.abr.audreybr.entity.Chouille;
import org.abr.audreybr.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChouilleRepository extends JpaRepository<Chouille, Integer> {

    Optional<Chouille> findById(Integer id);

    List<Chouille> getChouilleListByLocationHost(Person host);
    @Query(value = "SELECT * FROM Chouille c inner join Location l on c.Id_Location = l.Id_Location inner join Person p on l.Id_Person_Host = p.Id_Person WHERE l.Id_Person_Host = :host AND c.date > :dateNow ORDER BY c.date ASC ",
            nativeQuery = true)
    List<Chouille> getChouilleListByLocationHostAndDate(@Param("host")Integer host,@Param("dateNow") Date date );

    @Query(value = "SELECT * FROM Chouille c inner join Persons_Chouilles PC on c.id_Chouille = PC.Id_Chouille WHERE PC.Id_Person = :idUser ORDER BY c.date DESC LIMIT :limit",
            nativeQuery = true)
    List<Chouille> getChouilleListByIdPersonOrderedByDate(@Param("idUser") Integer id_person,@Param("limit")  Integer limit);

   /* @Query(value = "select * from Chouille C inner join Persons_Chouilles PC on C.Id_Chouille = PC.Id_Chouille where PC.Id_Person = :idUser",
            nativeQuery = true)*/
    List<Chouille> getChouillesByGuests(Person guest);

    Chouille getChouilleByCode(String code);
}
