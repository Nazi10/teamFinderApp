package com.fullsecurity.fullsecurity.dto;

import com.fullsecurity.fullsecurity.models.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ExpenseConfigurationDto {
    private Long id;

    private Double dailyExpenseLimit;

    private Boolean status = true;

    private Currency currency;
}
