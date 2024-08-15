package org.example.expensetracker.mapper;

import org.example.expensetracker.dto.ExpenseDto;
import org.example.expensetracker.model.Expense;
import org.mapstruct.Mapper;

@Mapper
public interface ExpenseMapper {

    ExpenseDto entityToDto(Expense expense);

    Expense dtoToEntity(ExpenseDto expenseDto);
}
