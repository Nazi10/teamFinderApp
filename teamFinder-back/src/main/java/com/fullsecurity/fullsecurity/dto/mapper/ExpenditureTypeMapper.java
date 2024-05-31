package com.fullsecurity.fullsecurity.dto.mapper;

import com.fullsecurity.fullsecurity.dto.ExpenditureTypeDto;
import com.fullsecurity.fullsecurity.models.ExpenditureType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpenditureTypeMapper extends BaseEntityMapper<ExpenditureTypeDto, ExpenditureType> {

    ExpenditureTypeDto toDto(ExpenditureType expenditureType);

    ExpenditureType toEntity(ExpenditureTypeDto expenditureTypeDto);

    List<ExpenditureTypeDto> toDto(List<ExpenditureType> expenditureTypes);

    List<ExpenditureType> toEntity(List<ExpenditureTypeDto> expenditureTypeDtos);
}
