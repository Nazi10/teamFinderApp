package com.fullsecurity.fullsecurity.services;

import com.fullsecurity.fullsecurity.dto.CurrencyConfigurationDto;

public interface CurrencyConfigurationService {

    void addCurrencyConfiguration(CurrencyConfigurationDto currencyConfigurationDto);

    Double getCurrencyConfiguration();
}
