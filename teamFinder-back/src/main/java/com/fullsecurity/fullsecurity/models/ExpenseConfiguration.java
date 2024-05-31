package com.fullsecurity.fullsecurity.models;

import com.fullsecurity.fullsecurity.models.enumeration.Currency;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
@Table(name = "expenseConfiguration")
@SQLRestriction("status = true")
public class ExpenseConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double dailyExpenseLimit;

    private Long userId; // to see for which user is this configuration

    private Boolean status;

    @Enumerated(EnumType.STRING)
    private Currency currency;
}
