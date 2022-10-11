package ru.vsu.cs.volchenko.interview.service;

import org.springframework.stereotype.Service;

@Service
public class VacationPayService {

    public int calculateVacationPay(int averageSalary, int countOfDays) {
        return (int) (averageSalary / 29.3) * countOfDays;
    }

}
