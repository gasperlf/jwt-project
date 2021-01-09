package net.ontopsolution.jwtproject.rest;

import lombok.RequiredArgsConstructor;
import net.ontopsolution.jwtproject.dtos.LoginRequest;
import net.ontopsolution.jwtproject.security.auth.SecurityConstants;
import net.ontopsolution.jwtproject.services.PeopleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class LoginController {

    private final PeopleService peopleService;

    @GetMapping(path = "")
    public ResponseEntity login(@RequestBody  LoginRequest loginRequest){
        return ResponseEntity.ok().header(SecurityConstants.HEADER_STRING,peopleService.login(loginRequest)).build();
    }
}
