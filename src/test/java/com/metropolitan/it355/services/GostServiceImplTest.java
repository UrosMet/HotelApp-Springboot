package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.Gost;
import com.metropolitan.it355.repository.GostRepository;
import com.metropolitan.it355.services.impl.GostServiceImpl;
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

public class GostServiceImplTest {

    @Mock
    private GostRepository gostRepository;

    @InjectMocks
    private GostServiceImpl gostService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        List<Gost> gosti = Arrays.asList(new Gost(), new Gost());
        when(gostRepository.findAll()).thenReturn(gosti);

        List<Gost> result = gostService.getAll();

        assertEquals(gosti, result);
    }

    @Test
    public void testGetById() {
        int id = 1;
        Gost gost = new Gost();
        when(gostRepository.findById(id)).thenReturn(Optional.of(gost));

        Optional<?> result = gostService.getById(id);

        assertTrue(result.isPresent());
        assertEquals(gost, result.get());
    }

    @Test
    public void testAdd() {
        Gost gost = new Gost();
        when(gostRepository.save(gost)).thenReturn(gost);

        Gost result = gostService.add(gost);

        assertEquals(gost, result);
    }

    @Test
    public void testUpdate() {
        Gost gost = new Gost();
        when(gostRepository.save(gost)).thenReturn(gost);

        Gost result = gostService.update(gost);

        assertEquals(gost, result);
    }

    @Test
    public void testDelete() {
        int id = 1;

        gostService.delete(id);

        verify(gostRepository, times(1)).deleteById(id);
    }

    @Test
    public void testGetAllWhenNoGosti() {
        List<Gost> emptyList = Collections.emptyList();
        when(gostRepository.findAll()).thenReturn(emptyList);

        List<Gost> result = gostService.getAll();

        assertEquals(emptyList, result);
    }

    @Test
    public void testGetByIdWhenNotFound() {
        int id = 1;
        when(gostRepository.findById(id)).thenReturn(Optional.empty());

        Optional<?> result = gostService.getById(id);

        assertFalse(result.isPresent());
    }

    @Test
    public void testAddWithNullGost() {
        Gost nullGost = null;
        when(gostRepository.save(nullGost)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> gostService.add(nullGost));
    }

    @Test
    public void testUpdateWithNullGost() {
        Gost nullGost = null;
        when(gostRepository.save(nullGost)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> gostService.update(nullGost));
    }

    @Test
    public void testDeleteNonExistingGost() {
        int id = 999;
        doThrow(EmptyResultDataAccessException.class).when(gostRepository).deleteById(id);

        assertThrows(EmptyResultDataAccessException.class, () -> gostService.delete(id));
    }
}
