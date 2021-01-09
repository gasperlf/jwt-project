package net.ontopsolution.jwtproject.services;

import net.ontopsolution.jwtproject.dtos.LoginRequest;
import net.ontopsolution.jwtproject.dtos.PeopleResponse;
import net.ontopsolution.jwtproject.dtos.PersonRequest;

import java.util.List;

public interface PeopleService {

    void registerPeople(PersonRequest request);

    List<PeopleResponse> getPeople();

    String login(LoginRequest loginRequest);
}
