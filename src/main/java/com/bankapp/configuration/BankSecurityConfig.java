package com.bankapp.configuration;

import com.bankapp.filter.JWTAuthorizationFilter;
import com.bankapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.logging.Level;
import java.util.logging.Logger;

@EnableWebSecurity
public class BankSecurityConfig extends WebSecurityConfigurerAdapter {
    private final Logger logger = Logger.getLogger("BankSecurityConfig");
    @Autowired
    private AuthService authService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.log(Level.INFO, "configure()");
        http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(authService), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated();
    }

}
