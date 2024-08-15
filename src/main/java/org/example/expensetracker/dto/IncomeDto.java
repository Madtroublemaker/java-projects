package org.example.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.expensetracker.enums.IncomeCategory;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDto {
    private String description;
    private Double amount;
    private IncomeCategory incomeCategory;
    private LocalDate createdDate;
}