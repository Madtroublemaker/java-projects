package org.example.expensetracker.repository;

import org.example.expensetracker.enums.ExpenseCategory;
import org.example.expensetracker.model.Expense;
import org.example.expensetracker.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByExpenseCategory(ExpenseCategory expenseCategory);

    List<Expense> findAllByCreatedDate(LocalDate date);
}
