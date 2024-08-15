package org.example.expensetracker.controller;

import lombok.AllArgsConstructor;
import org.example.expensetracker.dto.IncomeDto;
import org.example.expensetracker.enums.IncomeCategory;
import org.example.expensetracker.model.Income;
import org.example.expensetracker.service.IncomeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/income")
public class IncomeController {
    private IncomeService incomeService;

    @GetMapping
    public List<Income> getIncome() {
        return incomeService.getIncomes();
    }
    @GetMapping("/{id}")
    public Income getIncome(@PathVariable Long id) {
        return incomeService.getIncomeById(id);
    }

    @GetMapping("/category/{category}")
    public List<Income> getIncomeByIncomeCategory(@PathVariable IncomeCategory itemCategory) {
        return incomeService.getIncomeByIncomeCategory(itemCategory);
    }
    @GetMapping("/date/{date}")
    public List<Income> getIncomeByDate(@PathVariable @DateTimeFormat
            (iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return incomeService.getIncomeByDate(date);
    }
    @PostMapping("/create")
    public IncomeDto createIncome(@RequestBody Income income) {
        return incomeService.createIncome(income);
    }


}
