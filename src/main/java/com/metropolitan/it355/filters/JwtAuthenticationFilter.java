package com.metropolitan.it355.filters;

import com.metropolitan.it355.authentication.TokenBlackListService;
import com.metropolitan.it355.entity.Recepcioner;
import com.metropolitan.it355.jwt.JwtService;
import com.metropolitan.it355.repository.RecepcionerRepository;
import io.jsonwebtoken.security.SignatureException;
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

    @Autowired
    private TokenBlackListService tokenBlackListService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            String authHeader = request.getHeader("Authorization"); // Bearer jwt

            if(authHeader == null || !authHeader.startsWith("Bearer ")){
                filterChain.doFilter(request, response);
                //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Please login - No token provided");
                //extracted(response, "Please login - No token provided");
                return;
            }
            String jwt = authHeader.split(" ")[1];

            if (tokenBlackListService.isTokenBlacklisted(jwt)) {
                //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Please login - Token blacklisted");
                extracted(response, "Please login - Token blacklisted");
                return;
            }

            String username = jwtService.extractUsername(jwt);


            Recepcioner user = userRepository.findByKorisnickoIme(username).get();

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    username, null, user.getAuthorities()
            );

            SecurityContextHolder.getContext().setAuthentication(authToken);

            filterChain.doFilter(request, response);
        } catch (SignatureException e) {
            System.err.println(e.getMessage());
            //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT signature, please verify your JWT token. Please login.");
            extracted(response, "Invalid token or no token found");
        }catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An internal error occurred");
        }

    }

    private static void extracted(HttpServletResponse response , String s) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \""+s+"\"}");
        response.getWriter().flush();
        response.getWriter().close();
    }
}
