package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.entity.Recepcioner;
import com.metropolitan.it355.repository.RecepcionerRepository;
import com.metropolitan.it355.services.RecepcionerService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecepcionerServiceImpl implements RecepcionerService, UserDetailsService {

    final RecepcionerRepository recepcionerRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Metoda vraca sve Recepcionere
     *
     * @return List<Recepcioner>
     */
    @Override
    public List<Recepcioner> getAll() {
        return recepcionerRepository.findAll();
    }

    /**
     * Metoda vraca jednog Recepcionera po ID
     *
     * @param id
     * @return Recepcioner
     */
    @Override
    public Optional<?> getById(int id) {
        return recepcionerRepository.findById(id);
    }

    /**
     * Metoda dodaje jednog Recepcionera u bazu
     *
     * @param recepcioner
     * @return Recepcioner
     */
    @Override
    public Recepcioner add(Recepcioner recepcioner) {
        return recepcionerRepository.save(recepcioner);
    }

    /**
     * Metoda update-uje Recepcionera u bazu
     *
     * @param recepcioner
     * @return Recepcioner
     */
    @Override
    public Recepcioner update(Recepcioner recepcioner) {
        recepcioner.setLozinka(passwordEncoder.encode(recepcioner.getLozinka()));
        return recepcionerRepository.save(recepcioner);
    }

    /**
     * Metoda brise Recepcionera iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        recepcionerRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Recepcioner> recepcioner = recepcionerRepository.findByKorisnickoIme(username);
        if(recepcioner.isPresent()) {
            var recepcionerDetails = recepcioner.get();
            return User.builder()
                    .username(recepcionerDetails.getKorisnickoIme())
                    .password(recepcionerDetails.getLozinka())
                    .roles(getRoes(recepcionerDetails))
                    .build();
        }else
            throw new UsernameNotFoundException(username);
    }



    private String getRoes(Recepcioner recepcionerDetails) {
        if (recepcionerDetails.getRole() == null)
            return "USER";
        return recepcionerDetails.getRole();
    }


}
