package org.example.expensetracker.repository;

import org.example.expensetracker.enums.IncomeCategory;
import org.example.expensetracker.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findAllByCreatedDate(LocalDate date);

    List<Income> findByIncomeCategory(IncomeCategory incomeCategory);


}
