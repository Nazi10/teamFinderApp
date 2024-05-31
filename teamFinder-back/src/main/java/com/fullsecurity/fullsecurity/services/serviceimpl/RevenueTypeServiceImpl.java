package com.fullsecurity.fullsecurity.services.serviceimpl;

import com.fullsecurity.fullsecurity.dto.RevenueTypeDto;
import com.fullsecurity.fullsecurity.dto.mapper.RevenueTypeMapper;
import com.fullsecurity.fullsecurity.repository.RevenueRepository;
import com.fullsecurity.fullsecurity.repository.RevenueTypeRepository;
import com.fullsecurity.fullsecurity.services.RevenueTypeService;
import org.springframework.stereotype.Service;

@Service
public class RevenueTypeServiceImpl implements RevenueTypeService {

    private final RevenueTypeRepository revenueTypeRepository;
    private final RevenueTypeMapper revenueTypeMapper;

    public RevenueTypeServiceImpl(RevenueTypeRepository revenueTypeRepository, RevenueTypeMapper revenueTypeMapper) {
        this.revenueTypeRepository = revenueTypeRepository;
        this.revenueTypeMapper = revenueTypeMapper;
    }

    @Override
    public void addRevenueType(RevenueTypeDto revenueTypeDto) {
        this.revenueTypeRepository.save(this.revenueTypeMapper.toEntity(revenueTypeDto));
    }
}
