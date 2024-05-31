package com.fullsecurity.fullsecurity.dto.mapper;

import com.fullsecurity.fullsecurity.dto.EmailConfigurationDto;
import com.fullsecurity.fullsecurity.models.EmailConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailConfigurationMapper extends BaseEntityMapper<EmailConfigurationDto, EmailConfiguration> {

    EmailConfiguration toEntity(EmailConfigurationDto emailConfigurationDto);

    EmailConfigurationDto toDto(EmailConfiguration emailConfiguration);

    List<EmailConfiguration> toEntity(List<EmailConfigurationDto> emailConfigurationDtoList);

    List<EmailConfigurationDto> toDto(List<EmailConfiguration> emailConfigurations);

}
