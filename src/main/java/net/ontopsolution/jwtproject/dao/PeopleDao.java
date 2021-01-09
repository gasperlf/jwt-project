package net.ontopsolution.jwtproject.dao;

import net.ontopsolution.jwtproject.model.entities.People;

import java.util.List;

public interface PeopleDao {

    void registerPeople(People people);

    List<People> getPeople();

    People getPeople(String email);
}
