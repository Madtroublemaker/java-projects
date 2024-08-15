package org.example.expensetracker.service;

import lombok.AllArgsConstructor;
import org.example.expensetracker.dto.IncomeDto;
import org.example.expensetracker.enums.IncomeCategory;
import org.example.expensetracker.mapper.IncomeMapper;
import org.example.expensetracker.model.Income;
import org.example.expensetracker.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class IncomeService {
    private IncomeMapper incomeMapper;
    private IncomeRepository incomeRepository;

    public List<Income> getIncomes() {
        return incomeRepository.findAll();
    }
    public List<Income> getIncomeByDate(LocalDate date) {
        return incomeRepository.findAllByCreatedDate(date);
    }
    public Income getIncomeById(Long id) {
        return incomeRepository.findById(id).orElse(null);
    }
    public List<Income> getIncomeByIncomeCategory(IncomeCategory incomeCategory) {
        return incomeRepository.findByIncomeCategory(incomeCategory);
    }

    public IncomeDto createIncome(Income income) {
        Income createdIncome = incomeRepository.save(income);
        return incomeMapper.dtoToEntity(createdIncome);
    }
}
