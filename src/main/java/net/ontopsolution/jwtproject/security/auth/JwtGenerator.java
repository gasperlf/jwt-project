package net.ontopsolution.jwtproject.security.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class JwtGenerator {

    public static String generate(String jwtUser) {
        return Jwts.builder().setSubject(jwtUser)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET).compact();
    }
}
