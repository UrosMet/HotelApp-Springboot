package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.Rezervacija;
import com.metropolitan.it355.repository.RezervacijaRepository;
import com.metropolitan.it355.services.impl.RezervacijaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class RezervacijaServiceImplTest {

    @Mock
    private RezervacijaRepository rezervacijaRepository;

    @InjectMocks
    private RezervacijaServiceImpl rezervacijaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        List<Rezervacija> rezervacije = Arrays.asList(new Rezervacija(), new Rezervacija());
        when(rezervacijaRepository.findAll()).thenReturn(rezervacije);

        List<Rezervacija> result = rezervacijaService.getAll();

        assertEquals(rezervacije, result);
    }

    @Test
    public void testGetById() {
        int id = 1;
        Rezervacija rezervacija = new Rezervacija();
        when(rezervacijaRepository.findById(id)).thenReturn(Optional.of(rezervacija));

        Optional<?> result = rezervacijaService.getById(id);

        assertTrue(result.isPresent());
        assertEquals(rezervacija, result.get());
    }

    @Test
    public void testAdd() {
        Rezervacija rezervacija = new Rezervacija();
        when(rezervacijaRepository.save(rezervacija)).thenReturn(rezervacija);

        Rezervacija result = rezervacijaService.add(rezervacija);

        assertEquals(rezervacija, result);
    }

    @Test
    public void testUpdate() {
        Rezervacija rezervacija = new Rezervacija();
        when(rezervacijaRepository.save(rezervacija)).thenReturn(rezervacija);

        Rezervacija result = rezervacijaService.update(rezervacija);

        assertEquals(rezervacija, result);
    }

    @Test
    public void testDelete() {
        int id = 1;

        rezervacijaService.delete(id);

        verify(rezervacijaRepository, times(1)).deleteById(id);
    }

    @Test
    public void testSearchByIdSoba() {
        int idSoba = 1;
        List<Rezervacija> rezervacije = Arrays.asList(new Rezervacija(), new Rezervacija());
        when(rezervacijaRepository.findAllByIdSoba(idSoba)).thenReturn(rezervacije);

        List<Rezervacija> result = rezervacijaService.searchByIdSoba(idSoba);

        assertEquals(rezervacije, result);
    }

    @Test
    public void testSearchByIdGost() {
        int idGost = 1;
        List<Rezervacija> rezervacije = Arrays.asList(new Rezervacija(), new Rezervacija());
        when(rezervacijaRepository.findAllByIdGosta(idGost)).thenReturn(rezervacije);

        List<Rezervacija> result = rezervacijaService.searchByIdGost(idGost);

        assertEquals(rezervacije, result);
    }

    @Test
    public void testSearchByIdRecepcioner() {
        int idRecepcioner = 1;
        List<Rezervacija> rezervacije = Arrays.asList(new Rezervacija(), new Rezervacija());
        when(rezervacijaRepository.findAllByIdRecepcioner(idRecepcioner)).thenReturn(rezervacije);

        List<Rezervacija> result = rezervacijaService.searchByIdRecepcioner(idRecepcioner);

        assertEquals(rezervacije, result);
    }

    @Test
    public void testSearchByIdSobaWhenNoRezervacije() {
        int idSoba = 1;
        when(rezervacijaRepository.findAllByIdSoba(idSoba)).thenReturn(Arrays.asList());

        List<Rezervacija> result = rezervacijaService.searchByIdSoba(idSoba);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchByIdGostWhenNoRezervacije() {
        int idGost = 1;
        when(rezervacijaRepository.findAllByIdGosta(idGost)).thenReturn(Arrays.asList());

        List<Rezervacija> result = rezervacijaService.searchByIdGost(idGost);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchByIdRecepcionerWhenNoRezervacije() {
        int idRecepcioner = 1;
        when(rezervacijaRepository.findAllByIdRecepcioner(idRecepcioner)).thenReturn(Arrays.asList());

        List<Rezervacija> result = rezervacijaService.searchByIdRecepcioner(idRecepcioner);

        assertTrue(result.isEmpty());
    }

}
