package org.example.expensetracker.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.expensetracker.dto.ExpenseDto;
import org.example.expensetracker.enums.ExpenseCategory;
import org.example.expensetracker.model.Expense;
import org.example.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public List<Expense> getExpensesByDate(LocalDate date) {
        return expenseRepository.findAllByCreatedDate(date);
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public List<Expense> getExpensesByCategory(ExpenseCategory expenseCategory) {
        return expenseRepository.findByExpenseCategory(expenseCategory);
    }

    public ExpenseDto createExpense(Expense expense) {
        Expense createdExpense = expenseRepository.save(expense);
        return mapToDto(createdExpense);
    }

    private ExpenseDto mapToDto(Expense expense) {
        return new ExpenseDto(
                expense.getId(),
                expense.getDescription(),
                expense.getAmount(),
                expense.getExpenseCategory(),
                expense.getCreatedDate()
        );
    }
}
