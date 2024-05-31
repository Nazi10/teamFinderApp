package com.fullsecurity.fullsecurity.dto.mapper;

import com.fullsecurity.fullsecurity.dto.ExpenditureDto;
import com.fullsecurity.fullsecurity.dto.RevenueDto;
import com.fullsecurity.fullsecurity.models.Expenditure;
import com.fullsecurity.fullsecurity.models.Revenue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RevenueMapper extends BaseEntityMapper<RevenueDto, Revenue>{
    @Mapping(target = "dateOfRevenue", dateFormat = "dd-MM-yyyy")
    RevenueDto toDto(Revenue revenue);

    @Mapping(target = "dateOfRevenue", dateFormat = "yyyy-MM-dd")
    Revenue toEntity(RevenueDto revenueDto);

    List<RevenueDto> toDto(List<Revenue> revenues);

    List<Revenue> toEntity(List<RevenueDto> revenueDtos);
}
