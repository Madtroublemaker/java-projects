package org.example.expensetracker.mapper;

import org.example.expensetracker.dto.IncomeDto;
import org.example.expensetracker.model.Income;
import org.mapstruct.Mapper;

@Mapper
public interface IncomeMapper {

    IncomeDto entityToDto(Income income);

    IncomeDto dtoToEntity(Income income);

}
