package com.fullsecurity.fullsecurity.services.serviceimpl;

import com.fullsecurity.fullsecurity.dto.CurrencyConfigurationDto;
import com.fullsecurity.fullsecurity.dto.mapper.CurrencyConfigurationMapper;
import com.fullsecurity.fullsecurity.models.CurrencyConfiguration;
import com.fullsecurity.fullsecurity.repository.CurrencyConfigurationRepository;
import com.fullsecurity.fullsecurity.security.services.UserDetailsImpl;
import com.fullsecurity.fullsecurity.services.CurrencyConfigurationService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConfigurationImpl implements CurrencyConfigurationService {

    private final CurrencyConfigurationRepository currencyConfigurationRepository;

    private final CurrencyConfigurationMapper currencyConfigurationMapper;

    public CurrencyConfigurationImpl(CurrencyConfigurationRepository currencyConfigurationRepository, CurrencyConfigurationMapper currencyConfigurationMapper) {
        this.currencyConfigurationRepository = currencyConfigurationRepository;
        this.currencyConfigurationMapper = currencyConfigurationMapper;
    }

    @Override
    public void addCurrencyConfiguration(CurrencyConfigurationDto currencyConfigurationDto) {
        CurrencyConfiguration currencyConfiguration = this.currencyConfigurationRepository.findAllByUserId(UserDetailsImpl.getCurrentId());
        if (currencyConfiguration == null) {
            currencyConfiguration = new CurrencyConfiguration(null, currencyConfigurationDto.getExchangeRate(), UserDetailsImpl.getCurrentId(), true, currencyConfigurationDto.getCurrency());
        } else {
            currencyConfiguration.setExchangeRate(currencyConfigurationDto.getExchangeRate());
            currencyConfiguration.setCurrency(currencyConfigurationDto.getCurrency());
        }
        this.currencyConfigurationRepository.save(currencyConfiguration);
    }

    @Override
    public Double getCurrencyConfiguration() {
        CurrencyConfiguration currencyConfiguration = this.currencyConfigurationRepository.findAllByUserId(UserDetailsImpl.getCurrentId());
        if (currencyConfiguration != null) {
            return currencyConfiguration.getExchangeRate();
        } else {
            return null;
        }

    }
}
