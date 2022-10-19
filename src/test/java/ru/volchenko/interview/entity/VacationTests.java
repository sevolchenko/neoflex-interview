package ru.volchenko.interview.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.volchenko.interview.entity.Vacation;

import java.time.LocalDate;

public class VacationTests {

    @Test
    public void checkCountOfWorkingDays1() {
        LocalDate dateStart = LocalDate.parse("2022-10-01");
        LocalDate dateEnd = LocalDate.parse("2022-10-05");
        Assertions.assertEquals(2, Vacation.countOfDays(dateStart, dateEnd));
    }

    @Test
    public void checkCountOfWorkingDays2() {
        LocalDate dateStart1 = LocalDate.parse("2022-10-02");
        LocalDate dateStart2 = LocalDate.parse("2022-10-03");
        LocalDate dateEnd = LocalDate.parse("2022-10-05");
        Assertions.assertEquals(Vacation.countOfDays(dateStart1, dateEnd), Vacation.countOfDays(dateStart2, dateEnd));
    }

    @Test
    public void checkCountOfWorkingDays3() {
        LocalDate dateStart = LocalDate.parse("2022-10-03");
        LocalDate dateEnd = LocalDate.parse("2022-10-09");
        Assertions.assertEquals(5, Vacation.countOfDays(dateStart, dateEnd));
    }

    @Test
    public void checkCalculatedPay1() {
        int countOfWorkingDays = 5;
        int averageSalary = 6000;
        Assertions.assertEquals(1000, Vacation.calculateVacationPay(countOfWorkingDays, averageSalary));
    }

    @Test
    public void checkCalculatedPay2() {
        int countOfWorkingDays = 10;
        int averageSalary = 6000;
        Assertions.assertEquals(2000, Vacation.calculateVacationPay(countOfWorkingDays, averageSalary));
    }

    @Test
    public void checkCalculatedPay3() {
        int countOfWorkingDays = 30;
        int averageSalary = 8000;
        Assertions.assertEquals(8000, Vacation.calculateVacationPay(countOfWorkingDays, averageSalary));
    }

    @Test
    public void calculateVacationPay1() {
        Vacation vacation = new Vacation();

        vacation.setStartDate(LocalDate.parse("2022-10-01"));
        vacation.setEndDate(LocalDate.parse("2022-10-10"));
        vacation.setAverageSalary(6000);
        Assertions.assertEquals(1000, vacation.calculateVacationPay());
    }

    @Test
    public void calculateVacationPay2() {
        Vacation vacation = new Vacation();

        vacation.setStartDate(LocalDate.parse("2022-10-01"));
        vacation.setEndDate(LocalDate.parse("2022-10-31"));
        vacation.setAverageSalary(12000);
        Assertions.assertEquals(8000, vacation.calculateVacationPay());
    }

}
