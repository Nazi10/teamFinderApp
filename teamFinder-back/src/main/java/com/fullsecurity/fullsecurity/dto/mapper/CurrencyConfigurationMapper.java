package com.fullsecurity.fullsecurity.dto.mapper;
import com.fullsecurity.fullsecurity.dto.CurrencyConfigurationDto;
import com.fullsecurity.fullsecurity.models.CurrencyConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyConfigurationMapper extends BaseEntityMapper<CurrencyConfigurationDto, CurrencyConfiguration> {

    CurrencyConfiguration toEntity(CurrencyConfigurationDto currencyConfigurationDto);

    CurrencyConfigurationDto toDto(CurrencyConfiguration currencyConfiguration);

    List<CurrencyConfiguration> toEntity(List<CurrencyConfigurationDto> currencyConfigurationDtoList);

    List<CurrencyConfigurationDto> toDto(List<CurrencyConfiguration> currencyConfigurations);
}
