package com.fullsecurity.fullsecurity.dto.mapper;

import com.fullsecurity.fullsecurity.dto.ExpenditureDto;
import com.fullsecurity.fullsecurity.models.Expenditure;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpenditureMapper extends BaseEntityMapper<ExpenditureDto, Expenditure> {

    @Mapping(target = "dateOfExpend", dateFormat = "dd-MM-yyyy")
    ExpenditureDto toDto(Expenditure expenditure);

    @Mapping(target = "dateOfExpend", dateFormat = "yyyy-MM-dd")
    Expenditure toEntity(ExpenditureDto expenditureDto);

    List<ExpenditureDto> toDto(List<Expenditure> expenditures);

    List<Expenditure> toEntity(List<ExpenditureDto> expenditureDto);


}
