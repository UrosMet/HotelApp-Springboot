package com.metropolitan.it355.services;

import java.time.LocalDate;

public interface StatisticalService {

    /**
     * Metoda vraca ukupnu zaradu hotela
     * @return Double
     */
    Double totalEarnings();

    Double totalEarningsByDate(LocalDate startDate, LocalDate endDate);

}
