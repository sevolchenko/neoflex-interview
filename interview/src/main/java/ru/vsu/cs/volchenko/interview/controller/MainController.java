package ru.vsu.cs.volchenko.interview.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.volchenko.interview.service.VacationPayService;

@RestController
@AllArgsConstructor
public class MainController {

    private VacationPayService vacationPayService;

    @GetMapping("/calculate")
    public int calculateVacationPay(@RequestParam int averageSalary, @RequestParam int countOfDays) {
        return vacationPayService.calculateVacationPay(averageSalary, countOfDays);
    }

}
