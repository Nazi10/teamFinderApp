package com.fullsecurity.fullsecurity.services;

import com.fullsecurity.fullsecurity.dto.ExpenditureTypeDto;
import com.fullsecurity.fullsecurity.models.ExpenditureType;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface ExpenditureTypeService {
    String addExpenditureType(ExpenditureTypeDto expenditureTypeDto);

    List<ExpenditureTypeDto> getAllExpenditureTypes();

    String deleteExpenseType(Long id) throws BadRequestException;

    void editExpenditureType(ExpenditureTypeDto expenditureTypeDto);
}
