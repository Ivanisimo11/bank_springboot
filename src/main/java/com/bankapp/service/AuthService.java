package com.bankapp.service;

import com.bankapp.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "ivan228";


    public Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
    }

    public boolean checkJWTToken(HttpServletRequest request, HttpServletResponse res) {
        String authenticationHeader = request.getHeader(HEADER);
        if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
            return false;
        return true;
    }

    public String getJWTToken(String username) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("JWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        SECRET.getBytes()).compact();

        return PREFIX + token;
    }

    public User auth(User user) throws AuthException {
        int id = user.getId();
        String username = user.getUsername();
        String password = user.getPassword();
        if (userService.getUser(id) != null && userService.getUser(id).getPassword().equals(password)
                && userService.getUser(id).getUsername().equals(username)){
            String token = getJWTToken(username);
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setToken(token);
            return newUser;
        }
        throw new AuthException("Wrong authentication credentials.");
    }

}
