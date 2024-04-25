package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.repository.RezervacijaRepository;
import com.metropolitan.it355.services.StatisticalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class StatisticalServiceImpl implements StatisticalService {

    final RezervacijaRepository rezervacijaRepository;


    /**
     * Metoda vraca ukupnu zaradu hotela
     *
     * @return Double
     */
    @Override
    public Double totalEarnings() {
        return rezervacijaRepository.totaEarnings();
    }

    @Override
    public Double totalEarningsByDate(LocalDate startDate, LocalDate endDate) {
        return rezervacijaRepository.totalEarningsForPeriod(startDate,endDate);
    }


}
