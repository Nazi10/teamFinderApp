package com.fullsecurity.fullsecurity.dto;

import com.fullsecurity.fullsecurity.models.ExpenditureType;
import com.fullsecurity.fullsecurity.models.enumeration.Currency;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenditureDto {

    private Long id;

    private Double expends;

    private String dateOfExpend;

    private String comment;

    private ExpenditureTypeDto expenditureType;

    private Boolean status = true;

    private Currency currency;

}
