package net.ontopsolution.jwtproject.model.repositories;

import net.ontopsolution.jwtproject.model.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People,Integer> {

    @Query(value = "select o from People o where o.email=:email ")
    Optional<People> findPeopleByEmail(String email);
}
