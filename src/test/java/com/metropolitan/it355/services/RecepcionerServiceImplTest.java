package com.metropolitan.it355.services;

import com.metropolitan.it355.authentication.UserProvider;
import com.metropolitan.it355.entity.Recepcioner;
import com.metropolitan.it355.repository.RecepcionerRepository;
import com.metropolitan.it355.services.impl.RecepcionerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RecepcionerServiceImplTest {

    @Mock
    private RecepcionerRepository recepcionerRepository;

    @Mock
    private UserProvider userProvider;

    @InjectMocks
    private RecepcionerServiceImpl recepcionerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        List<Recepcioner> recepcioneri = Arrays.asList(new Recepcioner(), new Recepcioner());
        when(recepcionerRepository.findAll()).thenReturn(recepcioneri);

        List<Recepcioner> result = recepcionerService.getAll();

        assertEquals(recepcioneri, result);
    }

    @Test
    public void testGetById() {
        int id = 1;
        Recepcioner recepcioner = new Recepcioner();
        when(recepcionerRepository.findById(id)).thenReturn(Optional.of(recepcioner));

        Optional<?> result = recepcionerService.getById(id);

        assertTrue(result.isPresent());
        assertEquals(recepcioner, result.get());
    }

    @Test
    public void testAdd() {
        Recepcioner recepcioner = new Recepcioner();
        when(recepcionerRepository.save(recepcioner)).thenReturn(recepcioner);

        Recepcioner result = recepcionerService.add(recepcioner);

        assertEquals(recepcioner, result);
    }


    @Test
    public void testDelete() {
        int id = 1;

        recepcionerService.delete(id);

        verify(recepcionerRepository, times(1)).deleteById(id);
    }

    @Test
    public void testLoadUserByUsername() {
        String username = "username";
        String password = "password";
        Recepcioner recepcioner = new Recepcioner();
        recepcioner.setKorisnickoIme(username);
        recepcioner.setLozinka(password);
        when(recepcionerRepository.findByKorisnickoIme(username)).thenReturn(Optional.of(recepcioner));

        var userDetails = recepcionerService.loadUserByUsername(username);

        assertEquals(username, userDetails.getUsername());
        assertEquals(password, userDetails.getPassword());
    }

    @Test
    public void testLoadUserByUsernameWhenNotFound() {
        String username = "nonExistingUsername";
        when(recepcionerRepository.findByKorisnickoIme(username)).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> recepcionerService.loadUserByUsername(username));
    }

    @Test
    public void testLoadUserByUsernameNotFound() {
        String username = "nonExistingUsername";
        when(recepcionerRepository.findByKorisnickoIme(username)).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> recepcionerService.loadUserByUsername(username));
    }


}

