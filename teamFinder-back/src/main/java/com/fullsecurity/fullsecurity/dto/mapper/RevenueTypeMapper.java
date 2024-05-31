package com.fullsecurity.fullsecurity.dto.mapper;

import com.fullsecurity.fullsecurity.dto.RevenueTypeDto;
import com.fullsecurity.fullsecurity.models.RevenueType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RevenueTypeMapper extends BaseEntityMapper<RevenueTypeDto, RevenueType> {

    RevenueTypeDto toDto(RevenueType revenueType);

    RevenueType toEntity(RevenueTypeDto revenueTypeDto);

    List<RevenueType> toEntity(List<RevenueTypeDto> revenueTypeDto);

    List<RevenueTypeDto> toDto(List<RevenueType> revenueTypes);


}
