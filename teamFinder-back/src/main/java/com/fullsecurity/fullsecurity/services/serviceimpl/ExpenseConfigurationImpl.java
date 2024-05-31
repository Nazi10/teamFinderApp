package com.fullsecurity.fullsecurity.services.serviceimpl;

import com.fullsecurity.fullsecurity.dto.ExpenseConfigurationDto;
import com.fullsecurity.fullsecurity.dto.mapper.ExpenseConfigurationMapper;
import com.fullsecurity.fullsecurity.models.ExpenseConfiguration;
import com.fullsecurity.fullsecurity.models.enumeration.Currency;
import com.fullsecurity.fullsecurity.repository.ExpenseConfigurationRepository;
import com.fullsecurity.fullsecurity.security.services.UserDetailsImpl;
import com.fullsecurity.fullsecurity.services.ExpenseConfigurationService;
import org.springframework.stereotype.Service;

@Service
public class ExpenseConfigurationImpl implements ExpenseConfigurationService {

    private final ExpenseConfigurationRepository expenseConfigurationRepository;
    private final ExpenseConfigurationMapper expenseConfigurationMapper;

    public ExpenseConfigurationImpl(ExpenseConfigurationRepository expenseConfigurationRepository, ExpenseConfigurationMapper expenseConfigurationMapper) {
        this.expenseConfigurationRepository = expenseConfigurationRepository;
        this.expenseConfigurationMapper = expenseConfigurationMapper;
    }

    @Override
    public Double saveDailyExpenseLimit(Double expenseLimit, String currency) {
        ExpenseConfiguration expenseConfiguration = expenseConfigurationRepository.findAllByUserId(UserDetailsImpl.getCurrentId());
        if (expenseConfiguration == null) {
            if(currency.equals("LEK")) {
                expenseConfiguration = new ExpenseConfiguration(null, expenseLimit, UserDetailsImpl.getCurrentId(), true, Currency.LEK);
            } else {
                expenseConfiguration = new ExpenseConfiguration(null, expenseLimit, UserDetailsImpl.getCurrentId(), true, Currency.EUR);
            }
        } else {
            expenseConfiguration.setDailyExpenseLimit(expenseLimit);
        }
        expenseConfigurationRepository.save(expenseConfiguration);
        return expenseLimit;
    }

    @Override
    public ExpenseConfigurationDto getExpenseDailyConfig() {
        ExpenseConfiguration expenseConfiguration = expenseConfigurationRepository.findAllByUserId(UserDetailsImpl.getCurrentId());
        return expenseConfigurationMapper.toDto(expenseConfiguration);
    }
}
