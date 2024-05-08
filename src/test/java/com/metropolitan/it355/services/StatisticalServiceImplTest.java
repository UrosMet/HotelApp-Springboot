package com.metropolitan.it355.services;

import com.metropolitan.it355.repository.RezervacijaRepository;
import com.metropolitan.it355.services.impl.StatisticalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class StatisticalServiceImplTest {

    @Mock
    private RezervacijaRepository rezervacijaRepository;

    @InjectMocks
    private StatisticalServiceImpl statisticalService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTotalEarnings() {
        double expectedTotalEarnings = 1000.0;
        when(rezervacijaRepository.totaEarnings()).thenReturn(expectedTotalEarnings);

        double result = statisticalService.totalEarnings();

        assertEquals(expectedTotalEarnings, result);
    }

    @Test
    public void testTotalEarningsByDate() {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        double expectedTotalEarnings = 500.0;
        when(rezervacijaRepository.totalEarningsForPeriod(startDate, endDate)).thenReturn(expectedTotalEarnings);

        double result = statisticalService.totalEarningsByDate(startDate, endDate);

        assertEquals(expectedTotalEarnings, result);
    }
    @Test
    public void testTotalEarningsWhenRepositoryReturnsNull() {
        when(rezervacijaRepository.totaEarnings()).thenReturn(null);

        Double result = statisticalService.totalEarnings();

        assertNull(result);
    }


}

