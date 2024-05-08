package com.metropolitan.it355.jwt.filters;

import com.metropolitan.it355.authentication.TokenBlackListService;
import com.metropolitan.it355.entity.Recepcioner;
import com.metropolitan.it355.jwt.JwtService;
import com.metropolitan.it355.repository.RecepcionerRepository;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    private RecepcionerRepository userRepository;
    private TokenBlackListService tokenBlackListService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException,JwtException {
        try {
            String authHeader = request.getHeader("Authorization"); // Bearer jwt
            if(authHeader == null || !authHeader.startsWith("Bearer ")){
                filterChain.doFilter(request, response);
                return;
            }
            String jwt = authHeader.split(" ")[1];

            if (tokenBlackListService.isTokenBlacklisted(jwt)) {
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

        }
        catch (JwtException e) {
            System.err.println(e.getMessage());
            extracted(response, e.getMessage());
        }catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
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
