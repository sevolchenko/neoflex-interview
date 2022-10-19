package ru.volchenko.interview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.volchenko.interview.entity.Vacation;

import javax.validation.Valid;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(@ModelAttribute("vacation") Vacation vacation) {
        return "index";
    }


    @GetMapping("/calculate")
    public String calculate(@Valid @ModelAttribute("vacation") Vacation vacation,
                            Model model,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "index";
        }

        model.addAttribute("calculatedPay", vacation.calculateVacationPay());
        return "calculate";
    }
}
