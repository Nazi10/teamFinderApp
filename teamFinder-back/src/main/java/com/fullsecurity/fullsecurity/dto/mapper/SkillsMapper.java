package com.fullsecurity.fullsecurity.dto.mapper;

import com.fullsecurity.fullsecurity.dto.SkillsDto;
import com.fullsecurity.fullsecurity.models.Skills;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkillsMapper extends BaseEntityMapper<SkillsDto, Skills> {

    Skills toEntity(SkillsDto dto);

    SkillsDto toDto(Skills entity);

    @Override
    List<Skills> toEntity(List<SkillsDto> dtoList);

    @Override
    List<SkillsDto> toDto(List<Skills> entityList);
}
