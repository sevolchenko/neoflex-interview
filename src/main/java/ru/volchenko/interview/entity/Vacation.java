package ru.volchenko.interview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@NoArgsConstructor
@Setter
@Getter
@Component
@Validated
public class Vacation {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Start vacation date should not be empty")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "End vacation date should not be empty")
    private LocalDate endDate;

    @Min(value = 1, message = "Average Salary should be greater than 0")
    private int averageSalary;

    @AssertTrue(message = "End vacation date should be after than start vacation date")
    private boolean isLater() {
        return endDate.isBefore(startDate);
    }


    public int calculateVacationPay() {
        int countOfWorkingDays = countOfDays(startDate, endDate);

        return calculateVacationPay(countOfWorkingDays, averageSalary);
    }

    public static int calculateVacationPay(int countOfWorkingDays, int averageSalary) {
        return countOfWorkingDays * averageSalary / 30;
    }

    public static int countOfDays(LocalDate startDate, LocalDate endDate) {
        int countOfWorkingDays = 0;

        for (LocalDate currDate = startDate; currDate.isBefore(endDate); currDate = currDate.plusDays(1)) {
            if (currDate.getDayOfWeek().getValue() < 6) {
                countOfWorkingDays++;
            }
        }

        return countOfWorkingDays;
    }

}
