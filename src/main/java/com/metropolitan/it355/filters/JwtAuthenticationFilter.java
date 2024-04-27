package com.metropolitan.it355.filters;

import com.metropolitan.it355.entity.Recepcioner;
import com.metropolitan.it355.jwt.JwtService;
import com.metropolitan.it355.repository.RecepcionerRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RecepcionerRepository userRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1 obtain header that contains jwt

        String authHeader = request.getHeader("Authorization"); // Bearer jwt

        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        // 2 obtain jwt token
        String jwt = authHeader.split(" ")[1];

        // 3 obtain subject/username in jwt
        String username = jwtService.extractUsername(jwt);

        // 4 set authenticate object inside our secuirty context

        Recepcioner user = userRepository.findByKorisnickoIme(username).get();

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                username, null, user.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authToken);

        // 5 execute rest of the filters

        filterChain.doFilter(request, response);


    }
}
