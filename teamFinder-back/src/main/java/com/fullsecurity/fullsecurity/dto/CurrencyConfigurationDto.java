package com.fullsecurity.fullsecurity.dto;

import com.fullsecurity.fullsecurity.models.enumeration.Currency;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class CurrencyConfigurationDto {
    private Long id;

    private Double exchangeRate;

    private Boolean status = true;

    private Currency currency;
}
