package com.fullsecurity.fullsecurity.services;

import com.fullsecurity.fullsecurity.dto.RevenueDto;

import java.time.LocalDate;

public interface RevenueService {

    void addRevenue(RevenueDto revenueDto);

    Double getTodaysRevenue();

    Double getMonthlyRevenue();
}
