package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.SobaSlika;
import com.metropolitan.it355.repository.SobaSlikaRepository;
import com.metropolitan.it355.services.impl.SobaSlikaServiceImpl;
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

public class SobaSlikaServiceImplTest {

    @Mock
    private SobaSlikaRepository sobaSlikaRepository;

    @InjectMocks
    private SobaSlikaServiceImpl sobaSlikaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        List<SobaSlika> slike = Arrays.asList(new SobaSlika(), new SobaSlika());
        when(sobaSlikaRepository.findAll()).thenReturn(slike);

        List<SobaSlika> result = sobaSlikaService.getAll();

        assertEquals(slike, result);
    }

    @Test
    public void testGetById() {
        int id = 1;
        SobaSlika slika = new SobaSlika();
        when(sobaSlikaRepository.findById(id)).thenReturn(Optional.of(slika));

        Optional<?> result = sobaSlikaService.getById(id);

        assertTrue(result.isPresent());
        assertEquals(slika, result.get());
    }

    @Test
    public void testAdd() {
        SobaSlika slika = new SobaSlika();
        when(sobaSlikaRepository.save(slika)).thenReturn(slika);

        SobaSlika result = sobaSlikaService.add(slika);

        assertEquals(slika, result);
    }

    @Test
    public void testUpdate() {
        SobaSlika slika = new SobaSlika();
        when(sobaSlikaRepository.save(slika)).thenReturn(slika);

        SobaSlika result = sobaSlikaService.update(slika);

        assertEquals(slika, result);
    }

    @Test
    public void testDelete() {
        int id = 1;

        sobaSlikaService.delete(id);

        verify(sobaSlikaRepository, times(1)).deleteById(id);
    }

    @Test
    public void testGetAllByIdSoba() {
        int idSoba = 1;
        List<SobaSlika> slike = Arrays.asList(new SobaSlika(), new SobaSlika());
        when(sobaSlikaRepository.findAllByIdSoba(idSoba)).thenReturn(slike);

        List<SobaSlika> result = sobaSlikaService.getAllByIdSoba(idSoba);

        assertEquals(slike, result);
    }

    @Test
    public void testGetAllByIdSobaWhenNoSlike() {
        int idSoba = 1;
        when(sobaSlikaRepository.findAllByIdSoba(idSoba)).thenReturn(Arrays.asList());

        List<SobaSlika> result = sobaSlikaService.getAllByIdSoba(idSoba);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetAllByIdSobaWhenSlikeExist() {
        int idSoba = 1;
        List<SobaSlika> slike = Arrays.asList(new SobaSlika(), new SobaSlika());
        when(sobaSlikaRepository.findAllByIdSoba(idSoba)).thenReturn(slike);

        List<SobaSlika> result = sobaSlikaService.getAllByIdSoba(idSoba);

        assertEquals(slike, result);
    }

    @Test
    public void testDeleteWhenExists() {
        int id = 1;
        SobaSlika slika = new SobaSlika();
        when(sobaSlikaRepository.findById(id)).thenReturn(java.util.Optional.of(slika));

        sobaSlikaService.delete(id);

        verify(sobaSlikaRepository, times(1)).deleteById(id);
    }

}