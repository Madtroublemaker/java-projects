package org.example.expensetracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.expensetracker.enums.ExpenseCategory;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double amount;
    private ExpenseCategory expenseCategory;
    private LocalDate createdDate;
    @ManyToOne
    private User user;
}
