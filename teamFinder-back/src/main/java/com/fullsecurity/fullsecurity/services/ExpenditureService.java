package com.fullsecurity.fullsecurity.services;

import com.fullsecurity.fullsecurity.dto.ExpenditureDto;
import com.fullsecurity.fullsecurity.models.Expenditure;

import java.time.LocalDate;
import java.util.List;

public interface ExpenditureService {

    String addExpenditure(ExpenditureDto expenditureDto);

    List<ExpenditureDto> allExpenditureInAMonth();

    boolean deleteExpenditureById(Long id);

    Double totalExpendsInADay(LocalDate date);
    Double getMonthlyExpends();

    String editExpenditure(ExpenditureDto expenditureDto);

    List<ExpenditureDto> expenditureStartToEndDate(String fromDate, String toDate);
}
