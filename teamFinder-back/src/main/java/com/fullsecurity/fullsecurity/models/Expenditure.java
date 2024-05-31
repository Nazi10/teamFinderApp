package com.fullsecurity.fullsecurity.models;

import com.fullsecurity.fullsecurity.models.enumeration.Currency;
import com.fullsecurity.fullsecurity.models.enumeration.ERole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "expenditure")
@SQLRestriction("status = true")
public class Expenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double expends;

    private LocalDate dateOfExpend;

    @Size(max = 300)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "expenditureType_id", referencedColumnName = "id")
    private ExpenditureType expenditureType;

    private Boolean status;

    @Enumerated(EnumType.STRING)
    private Currency currency;

}
