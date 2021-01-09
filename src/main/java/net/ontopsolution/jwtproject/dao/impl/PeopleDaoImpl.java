package net.ontopsolution.jwtproject.dao.impl;

import lombok.RequiredArgsConstructor;
import net.ontopsolution.jwtproject.dao.PeopleDao;
import net.ontopsolution.jwtproject.model.repositories.PeopleRepository;
import net.ontopsolution.jwtproject.model.entities.People;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PeopleDaoImpl implements PeopleDao {

    private final PeopleRepository peopleRepository;

    public void registerPeople(People people){
        People  p = peopleRepository.save(people);
    }

    public List<People> getPeople(){
        return peopleRepository.findAll();
    }

    public People getPeople(String email){
        return  peopleRepository.findPeopleByEmail(email).orElse(null);
    }
}
