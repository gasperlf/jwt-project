package net.ontopsolution.jwtproject.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.ontopsolution.jwtproject.dao.PeopleDao;
import net.ontopsolution.jwtproject.dtos.LoginRequest;
import net.ontopsolution.jwtproject.dtos.PeopleResponse;
import net.ontopsolution.jwtproject.dtos.PersonRequest;
import net.ontopsolution.jwtproject.model.entities.People;
import net.ontopsolution.jwtproject.security.auth.JwtGenerator;
import net.ontopsolution.jwtproject.services.PeopleService;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PeopleServiceImpl implements PeopleService {

    private final PeopleDao peopleDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void registerPeople(PersonRequest request) {
        People people = new People();
        people.setName(request.getName());
        people.setLastName(request.getLastName());
        people.setEmail(request.getEmail());
        people.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        peopleDao.registerPeople(people);
    }

    @Override
    public List<PeopleResponse> getPeople() {
        String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("user querying data {}", user);
        return peopleDao.getPeople().stream().map(p -> {
            PeopleResponse response = new PeopleResponse();
            response.setId(p.getId());
            response.setName(p.getName());
            response.setLastName(p.getLastName());
            response.setEmail(p.getEmail());
            response.setPwd(p.getPassword());
            return response;
        }).collect(Collectors.toList());
    }

    @Override
    public String login(LoginRequest request){

        People people = peopleDao.getPeople(request.getUser());
        if(people== null){
            throw new RuntimeException("Not found");
        }
        if(bCryptPasswordEncoder.matches(request.getPwd(),people.getPassword())){
          return JwtGenerator.generate(request.getUser());
        }
        throw new RuntimeException("Invalid user");
    }
}
