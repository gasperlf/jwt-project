package net.ontopsolution.jwtproject.security.config;

import net.ontopsolution.jwtproject.security.auth.JWTAuthenticationFilter;
import net.ontopsolution.jwtproject.security.auth.JWTAuthorizationFilter;
import net.ontopsolution.jwtproject.security.auth.JwtAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin().disable()
                .authorizeRequests()
                .antMatchers("/people","/login").permitAll()
                .anyRequest().authenticated()
                .and()
                // Call our errorHandler if authentication/authorisation fails
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                // don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //.addFilterBefore(new ConfigCorsFilter(), ChannelProcessingFilter.class)
                //.addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()));

        http
                .headers()
                .contentTypeOptions()
                .and()
                .referrerPolicy()
                .and()
                .httpStrictTransportSecurity().includeSubDomains(false)
                .and()
                .xssProtection().block(true)
                .and()
                .frameOptions()
                .deny();
    }

}
