package com.fullsecurity.fullsecurity.services;

import com.fullsecurity.fullsecurity.dto.ExpenseConfigurationDto;

public interface ExpenseConfigurationService {
    Double saveDailyExpenseLimit(Double expenseLimit, String currency);

    ExpenseConfigurationDto getExpenseDailyConfig();
}
