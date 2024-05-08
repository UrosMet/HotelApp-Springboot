package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.Cenovnik;
import com.metropolitan.it355.repository.CenovnikRepository;
import com.metropolitan.it355.services.impl.CenovnikServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CenovnikServiceImplTest {

    @Mock
    private CenovnikRepository cenovnikRepository;

    @InjectMocks
    private CenovnikServiceImpl cenovnikService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        List<Cenovnik> cenovnici = Arrays.asList(new Cenovnik(), new Cenovnik());
        when(cenovnikRepository.findAll()).thenReturn(cenovnici);

        List<Cenovnik> result = cenovnikService.getAll();

        assertEquals(cenovnici, result);
    }

    @Test
    public void testGetById() {
        int id = 1;
        Cenovnik cenovnik = new Cenovnik();
        when(cenovnikRepository.findById(id)).thenReturn(Optional.of(cenovnik));

        Optional<Cenovnik> result = cenovnikService.getById(id);

        assertTrue(result.isPresent());
        assertEquals(cenovnik, result.get());
    }

    @Test
    public void testAdd() {
        Cenovnik cenovnik = new Cenovnik();
        when(cenovnikRepository.save(cenovnik)).thenReturn(cenovnik);

        Cenovnik result = cenovnikService.add(cenovnik);

        assertEquals(cenovnik, result);
    }

    @Test
    public void testUpdate() {
        Cenovnik cenovnik = new Cenovnik();
        when(cenovnikRepository.save(cenovnik)).thenReturn(cenovnik);

        Cenovnik result = cenovnikService.update(cenovnik);

        assertEquals(cenovnik, result);
    }

    @Test
    public void testDelete() {
        int id = 1;

        cenovnikService.delete(id);

        verify(cenovnikRepository, times(1)).deleteById(id);
    }

    @Test
    public void testGetAllWhenNoCenovnici() {
        List<Cenovnik> emptyList = Collections.emptyList();
        when(cenovnikRepository.findAll()).thenReturn(emptyList);

        List<Cenovnik> result = cenovnikService.getAll();

        assertEquals(emptyList, result);
    }

    @Test
    public void testGetByIdWhenNotFound() {
        int id = 1;
        when(cenovnikRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Cenovnik> result = cenovnikService.getById(id);

        assertFalse(result.isPresent());
    }

    @Test
    public void testAddWithNullCenovnik() {
        Cenovnik nullCenovnik = null;
        when(cenovnikRepository.save(nullCenovnik)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> cenovnikService.add(nullCenovnik));
    }

    @Test
    public void testUpdateWithNullCenovnik() {
        Cenovnik nullCenovnik = null;
        when(cenovnikRepository.save(nullCenovnik)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> cenovnikService.update(nullCenovnik));
    }

    @Test
    public void testDeleteNonExistingCenovnik() {
        int id = 999;
        doThrow(EmptyResultDataAccessException.class).when(cenovnikRepository).deleteById(id);

        assertThrows(EmptyResultDataAccessException.class, () -> cenovnikService.delete(id));
    }
}