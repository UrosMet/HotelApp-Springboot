package com.metropolitan.it355.controller;

import com.metropolitan.it355.services.StatisticalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminCotroller {

    final StatisticalService statisticalService;

    @GetMapping("/earnings")
    public ResponseEntity<Double> getEarnings() {
        return ResponseEntity.ok(statisticalService.totalEarnings());
    }

    @GetMapping("/earnings/date")
    public ResponseEntity<Double> getEarnings(@RequestParam(name = "startDate") String startDate,
                                            @RequestParam(name = "endDate") String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return ResponseEntity.ok(statisticalService.totalEarningsByDate(start,end));
    }

}
