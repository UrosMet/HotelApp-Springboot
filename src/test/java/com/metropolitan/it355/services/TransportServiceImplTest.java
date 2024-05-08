package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.Transport;
import com.metropolitan.it355.repository.TransportRepository;
import com.metropolitan.it355.services.impl.TransportServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransportServiceImplTest {
    @Mock
    private TransportRepository transportRepository;

    @InjectMocks
    private TransportServiceImpl transportService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        List<Transport> transports = new ArrayList<>();
        // Popunite listu sa primjerima Transport objekata

        when(transportRepository.findAll()).thenReturn(transports);

        List<Transport> result = transportService.getAll();

        assertEquals(transports, result);
    }

    @Test
    public void testGetById() {
        int id = 1;
        Transport transport = new Transport();
        // Postavite odgovarajuće parametre za transport objekat

        when(transportRepository.findById(id)).thenReturn(Optional.of(transport));

        Optional<?> result = transportService.getById(id);

        assertEquals(Optional.of(transport), result);
    }

    @Test
    public void testAdd() {
        Transport transport = new Transport();
        // Postavite odgovarajuće parametre za transport objekat

        when(transportRepository.save(transport)).thenReturn(transport);

        Transport result = transportService.add(transport);

        assertEquals(transport, result);
    }

    @Test
    public void testUpdate() {
        Transport transport = new Transport();
        // Postavite odgovarajuće parametre za transport objekat

        when(transportRepository.save(transport)).thenReturn(transport);

        Transport result = transportService.update(transport);

        assertEquals(transport, result);
    }

    @Test
    public void testDelete() {
        int id = 1;

        transportService.delete(id);

        verify(transportRepository, times(1)).deleteById(id);
    }

    @Test
    public void testGetAllWhenNoTransports() {
        List<Transport> emptyList = Collections.emptyList();
        when(transportRepository.findAll()).thenReturn(emptyList);

        List<Transport> result = transportService.getAll();

        assertEquals(emptyList, result);
    }

    @Test
    public void testGetByIdWhenNotFound() {
        int id = 1;
        when(transportRepository.findById(id)).thenReturn(Optional.empty());

        Optional<?> result = transportService.getById(id);

        assertFalse(result.isPresent());
    }

    @Test
    public void testAddWithNullTransport() {
        Transport nullTransport = null;
        when(transportRepository.save(nullTransport)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> transportService.add(nullTransport));
    }

    @Test
    public void testUpdateWithNullTransport() {
        Transport nullTransport = null;
        when(transportRepository.save(nullTransport)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> transportService.update(nullTransport));
    }

    @Test
    public void testDeleteNonExistingTransport() {
        int id = 999;
        doThrow(EmptyResultDataAccessException.class).when(transportRepository).deleteById(id);

        assertThrows(EmptyResultDataAccessException.class, () -> transportService.delete(id));
    }
}
