package org.example.expensetracker.dto;

import lombok.*;
import org.example.expensetracker.enums.ExpenseCategory;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {

    private Long id;
    private String description;
    private Double amount;
    private ExpenseCategory expenseCategory;
    private LocalDate createdDate;
}
