package com.fullsecurity.fullsecurity.dto.mapper;

import com.fullsecurity.fullsecurity.dto.ExpenseConfigurationDto;
import com.fullsecurity.fullsecurity.models.ExpenseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpenseConfigurationMapper extends BaseEntityMapper<ExpenseConfigurationDto, ExpenseConfiguration> {
    ExpenseConfigurationDto toDto(ExpenseConfiguration expenseConfiguration);

    ExpenseConfiguration toEntity(ExpenseConfigurationDto expenseConfigurationDto);

    List<ExpenseConfigurationDto> toDto(List<ExpenseConfiguration> expenseConfigurations);

    List<ExpenseConfiguration> toEntity(List<ExpenseConfigurationDto> expenseConfigurationDtos);
}
