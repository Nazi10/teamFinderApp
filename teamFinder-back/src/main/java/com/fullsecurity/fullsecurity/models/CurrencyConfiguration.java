package com.fullsecurity.fullsecurity.models;

import com.fullsecurity.fullsecurity.models.enumeration.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "currencyConfiguration")
@SQLRestriction("status = true")
public class CurrencyConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double exchangeRate;

    private Long userId; // to see for which user is this configuration

    private Boolean status;

    @Enumerated(EnumType.STRING)
    private Currency currency;
}
