package net.ontopsolution.jwtproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    private String name;
    private String lastName;
    private String email;
    private String password;
}
