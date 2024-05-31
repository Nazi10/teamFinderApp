package com.fullsecurity.fullsecurity.dto;
import com.fullsecurity.fullsecurity.models.enumeration.Currency;
import lombok.Data;


@Data
public class RevenueDto {
    private Long id;

    private Double revenue;

    private String revenueName;

    private String dateOfRevenue;

    private Boolean status = true;

    private Currency currency;

    private RevenueTypeDto revenueType;
}
