package com.fullsecurity.fullsecurity.services.serviceimpl;

import com.fullsecurity.fullsecurity.dto.RevenueDto;
import com.fullsecurity.fullsecurity.dto.mapper.RevenueMapper;
import com.fullsecurity.fullsecurity.models.Revenue;
import com.fullsecurity.fullsecurity.repository.RevenueRepository;
import com.fullsecurity.fullsecurity.services.RevenueService;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RevenueServiceImpl implements RevenueService {

    private final RevenueMapper revenueMapper;

    private final RevenueRepository revenueRepository;

    public RevenueServiceImpl(RevenueMapper revenueMapper, RevenueRepository revenueRepository) {
        this.revenueMapper = revenueMapper;
        this.revenueRepository = revenueRepository;
    }

    @Override
    public void addRevenue(RevenueDto revenueDto) {
        Revenue revenue = this.revenueMapper.toEntity(revenueDto);
        this.revenueRepository.save(revenue);
    }

    @Override
    public Double getTodaysRevenue() {
        List<Revenue> allRevenues = this.revenueRepository.findAllByDateOfRevenue(LocalDate.now());
        double total = 0.0;
        if (!allRevenues.isEmpty()) {
            total = allRevenues.stream().mapToDouble(Revenue::getRevenue).sum();
        }
        return total;
    }

    @Override
    public Double getMonthlyRevenue() {
        List<Revenue> allRevenues = this.revenueRepository.findAllByDateOfRevenueIsBetweenOrderByDateOfRevenueDesc
                (LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1), LocalDate.now());
        double total = 0.0;
        if(!allRevenues.isEmpty()) {
            total = allRevenues.stream().mapToDouble(Revenue::getRevenue).sum();
        }
        return total;
    }
}
