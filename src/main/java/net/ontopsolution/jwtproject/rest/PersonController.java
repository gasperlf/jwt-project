package net.ontopsolution.jwtproject.rest;

import lombok.RequiredArgsConstructor;
import net.ontopsolution.jwtproject.dtos.PeopleResponse;
import net.ontopsolution.jwtproject.dtos.PersonRequest;
import net.ontopsolution.jwtproject.services.PeopleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class PersonController {

    private final PeopleService peopleService;

    @PostMapping(path = "/people", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody PersonRequest request){
        peopleService.registerPeople(request);
    }

    @GetMapping(value = "/auth/people", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PeopleResponse>get(){
        return peopleService.getPeople();
    }
}
