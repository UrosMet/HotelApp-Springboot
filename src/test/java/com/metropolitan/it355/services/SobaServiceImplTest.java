package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.Soba;
import com.metropolitan.it355.repository.SobaRepository;
import com.metropolitan.it355.services.impl.SobaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SobaServiceImplTest {

    @Mock
    private SobaRepository sobaRepository;

    @InjectMocks
    private SobaServiceImpl sobaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        List<Soba> sobe = Arrays.asList(new Soba(), new Soba());
        when(sobaRepository.findAll()).thenReturn(sobe);

        List<Soba> result = sobaService.getAll();

        assertEquals(sobe, result);
    }

    @Test
    public void testGetById() {
        int id = 1;
        Soba soba = new Soba();
        when(sobaRepository.findById(id)).thenReturn(Optional.of(soba));

        Optional<?> result = sobaService.getById(id);

        assertTrue(result.isPresent());
        assertEquals(soba, result.get());
    }

    @Test
    public void testAdd() {
        Soba soba = new Soba();
        when(sobaRepository.save(soba)).thenReturn(soba);

        Soba result = sobaService.add(soba);

        assertEquals(soba, result);
    }

    @Test
    public void testUpdate() {
        Soba soba = new Soba();
        when(sobaRepository.save(soba)).thenReturn(soba);

        Soba result = sobaService.update(soba);

        assertEquals(soba, result);
    }

    @Test
    public void testDelete() {
        int id = 1;

        sobaService.delete(id);

        verify(sobaRepository, times(1)).deleteById(id);
    }
    @Test
    public void testGetByIdWhenNotExists() {
        int id = 1;
        when(sobaRepository.findById(id)).thenReturn(Optional.empty());

        Optional<?> result = sobaService.getById(id);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testAddWhenSavedSuccessfully() {
        Soba soba = new Soba();
        when(sobaRepository.save(soba)).thenReturn(soba);

        Soba result = sobaService.add(soba);

        assertNotNull(result);
        assertEquals(soba, result);
    }

    @Test
    public void testUpdateWhenSavedSuccessfully() {
        Soba soba = new Soba();
        when(sobaRepository.save(soba)).thenReturn(soba);

        Soba result = sobaService.update(soba);

        assertNotNull(result);
        assertEquals(soba, result);
    }

    @Test
    public void testDeleteWhenExists() {
        int id = 1;
        Soba soba = new Soba();
        when(sobaRepository.findById(id)).thenReturn(Optional.of(soba));

        sobaService.delete(id);

        verify(sobaRepository, times(1)).deleteById(id);
    }
}

