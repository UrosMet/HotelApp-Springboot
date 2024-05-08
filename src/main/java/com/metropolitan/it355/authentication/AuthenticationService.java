package com.metropolitan.it355.authentication;

import com.metropolitan.it355.dto.LoginDTO;
import com.metropolitan.it355.dto.LoginResponse;
import com.metropolitan.it355.entity.Recepcioner;
import com.metropolitan.it355.jwt.JwtService;
import com.metropolitan.it355.repository.RecepcionerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final RecepcionerRepository userRepository;
    private final JwtService jwtService;
    private final TokenBlackListService tokenBlackListService;
    private final PasswordEncoder passwordEncoder;





    public LoginResponse register(Recepcioner request){
        var user = new Recepcioner();
        user.setIme(request.getIme());
        user.setPrezime(request.getPrezime());
        user.setKorisnickoIme(request.getKorisnickoIme());
        user.setLozinka(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        String token = jwtService.generateToken(user, generateExtraClaims(user));
        return  new LoginResponse(token);
    }




    public LoginResponse login(LoginDTO authenticationRequest){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()
        );
        authenticationManager.authenticate(authToken);
        Recepcioner user = userRepository.findByKorisnickoIme(authenticationRequest.getUsername()).get();
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        return new LoginResponse(jwt);
    }

    public void logout(String token) {
        tokenBlackListService.blacklistToken(token);
        SecurityContextHolder.clearContext();
    }


    private Map<String, Object> generateExtraClaims(Recepcioner user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("ID_Recepcionera" , user.getId());
        extraClaims.put("Ime" , user.getIme());
        extraClaims.put("Prezime" , user.getPrezime());
        extraClaims.put("Korisnicko_Ime" , user.getKorisnickoIme());
        extraClaims.put("Role" , user.getRole());
        return extraClaims;
    }
}
